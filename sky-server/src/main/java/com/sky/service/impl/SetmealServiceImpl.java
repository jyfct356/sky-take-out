package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.SetmealService;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class SetmealServiceImpl implements SetmealService {
    @Autowired
    private SetmealMapper setmealMapper;
    @Autowired
    private SetmealDishMapper setmealDishMapper;

    /**
     * 根据分类id获取套餐
     * @param categoryId
     * @return
     */
    @Override
    public List<Setmeal> getSetmealByCategoryId(Integer categoryId) {
        return setmealMapper.getSetmealByCategoryId(categoryId);
    }

    /**
     * 根据套餐id获取套餐内菜品
     * @param id
     * @return
     */
    @Override
    public List<DishItemVO> getSetmealDishesById(Integer id) {
        return setmealMapper.getSetmealDishesWithDescById(id);
    }

    /**
     * 分页查询套餐
     * @param setmealPageQueryDTO
     * @return
     */
    @Override
    public PageResult getSetmealPage(SetmealPageQueryDTO setmealPageQueryDTO) {
        PageHelper.startPage(setmealPageQueryDTO.getPage(), setmealPageQueryDTO.getPageSize());
        Page<Setmeal> page = setmealMapper.getSetmealPage(setmealPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    @Override
    public SetmealVO getSetmealById(String id) {
        SetmealVO setmealVO = setmealMapper.getSetmealWithCategoryNameById(id);
        setmealVO.setSetmealDishes(setmealDishMapper.getSetmealDishesById(id));
        return setmealVO;
    }

    /**
     * 新增套餐
     * @param setmealDTO
     */
    @Override
    @Transactional
    public void addSetmeal(SetmealDTO setmealDTO) {
        Setmeal setmeal = new Setmeal();
        BeanUtils.copyProperties(setmealDTO, setmeal);
        setmealMapper.addSetmeal(setmeal);
        List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes();
        setmealDishes.forEach(setmealDish -> {
            setmealDish.setSetmealId(setmeal.getId());
        });
        setmealDishMapper.addSetmealDishes(setmealDishes);
    }

    /**
     * 套餐状态起售停售
     * @param status
     */
    @Override
    public void setSetmealStatus(String status, String id) {
        setmealMapper.setSetmealStatus(status, id);
    }

    /**
     * 批量删除套餐...
     * @param ids
     */
    @Transactional
    @Override
    public void deleteSetmealByIds(String ids) {
        String[] idArray = ids.split(",");
        setmealMapper.deleteSetmealByIds(idArray);
        setmealDishMapper.deleteSetmealDishesByIds(idArray);
    }

    /**
     * 修改套餐
     * @param setmealDTO
     */
    @Override
    @Transactional
    public void updateSetmeal(SetmealDTO setmealDTO) {
        Setmeal setmeal = new Setmeal();
        BeanUtils.copyProperties(setmealDTO, setmeal);
        setmealMapper.updateSetmeal(setmeal);
        String[] ids = new String[1];
        ids[0] = setmeal.getId().toString();
        setmealDishMapper.deleteSetmealDishesByIds(ids);
        setmealDishMapper.addSetmealDishes(setmealDTO.getSetmealDishes());
    }
}
