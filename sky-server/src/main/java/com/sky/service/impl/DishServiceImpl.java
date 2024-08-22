package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.entity.SetmealDish;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishFlavorMapper dishFlavorMapper;
    @Autowired
    private SetmealDishMapper setmealDishMapper;

    /**
     * 添加菜品
     * @param dishDTO
     */
    @Transactional
    @Override
    public void addDishWithFlavor(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);
        dishMapper.addDish(dish);
        List<DishFlavor> dishFlavors = dishDTO.getFlavors();
        dishFlavors.forEach(dishFlavor -> {
            dishFlavor.setDishId(dish.getId());
        });
        dishFlavorMapper.addDishFlavors(dishFlavors);

    }

    /**
     * 分页查询菜品
     * @param dishPageQueryDTO
     * @return
     */
    @Override
    public PageResult getDishPage(DishPageQueryDTO dishPageQueryDTO) {
        PageHelper.startPage(dishPageQueryDTO.getPage(), dishPageQueryDTO.getPageSize());
        Page<DishVO> page = dishMapper.getDishPage(dishPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 起售、停售菜品
     * @param status
     * @param id
     */
    @Override
    public void setDishStatus(Integer status, String id) {
        dishMapper.setDishStatus(status, id);
    }

    /**
     * 根据id查询菜品
     * @param id
     * @return
     */
    @Transactional
    @Override
    public DishVO getDishById(String id) {
        DishVO dishVO = dishMapper.getDishById(id);
        dishVO.setFlavors(dishFlavorMapper.getDishFlavorsByDishId(id));
        return dishVO;
    }

    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    @Override
    public List<Dish> getDishByCategoryId(Long categoryId) {
        return dishMapper.getDishByCategoryId(categoryId);
    }

    /**
     * 根据id批量删除菜品
     * @param ids
     */
    @Transactional
    @Override
    public void deleteDishByIds(String ids) {
        String[] idArray = ids.split(",");
        List<Integer> allStatus = dishMapper.getStatusByIds(idArray);
        for (Integer status: allStatus) {
            if (status == StatusConstant.ENABLE) {
                throw new DeletionNotAllowedException(MessageConstant.DISH_ON_SALE);
            }
        }
        
        List<SetmealDish> setmealDishes = setmealDishMapper.getByDishIds(idArray);
        if (setmealDishes != null && setmealDishes.size() > 0) {
            throw new DeletionNotAllowedException(MessageConstant.DISH_BE_RELATED_BY_SETMEAL);
        }
        
        dishMapper.deleteDishByIds(idArray);
        dishFlavorMapper.deleteDishFlavorByDishIds(idArray);
    }

    /**
     * 修改菜品
     * @param dishDTO
     */
    @Transactional
    @Override
    public void updateDish(DishDTO dishDTO) {
        String[] ids = new String[1];
        ids[0] = dishDTO.getId().toString();
        dishFlavorMapper.deleteDishFlavorByDishIds(ids);
        dishMapper.updateDish(dishDTO);
        List<DishFlavor> dishFlavors = dishDTO.getFlavors();
        dishFlavors.forEach(dishFlavor -> {
            dishFlavor.setDishId(dishDTO.getId());
        });
        dishFlavorMapper.addDishFlavors(dishFlavors);
    }
}
