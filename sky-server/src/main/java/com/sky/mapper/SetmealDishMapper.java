package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据dish_id查询套餐菜品
     * @param dishIds
     * @return
     */
    List<SetmealDish> getByDishIds(String[] dishIds);

    /**
     * 根据id查询套餐菜品
     * @param id
     * @return
     */
    List<SetmealDish> getSetmealDishesById(String id);

    /**
     * 添加套餐的菜品们
     * @param setmealDishes
     */
    void addSetmealDishes(List<SetmealDish> setmealDishes);

    /**
     * 根据套餐id批量删除套餐菜品
     * @param idArray
     */
    void deleteSetmealDishesByIds(String[] idArray);
}
