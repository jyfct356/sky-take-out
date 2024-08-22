package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DishService {
    /**
     * 添加菜品
     * @param dishDTO
     */
    void addDishWithFlavor(DishDTO dishDTO);

    /**
     * 分页查询菜品
     * @param dishPageQueryDTO
     * @return
     */
    PageResult getDishPage(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 起售、停售菜品
     * @param status
     * @param id
     */
    void setDishStatus(Integer status, String id);

    /**
     * 根据id查询菜品
     * @param id
     * @return
     */
    DishVO getDishById(String id);

    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    List<Dish> getDishByCategoryId(Long categoryId);

    /**
     * 根据id批量删除菜品
     * @param ids
     */
    void deleteDishByIds(String ids);

    /**
     * 修改菜品
     * @param dishDTO
     */
    void updateDish(DishDTO dishDTO);
}
