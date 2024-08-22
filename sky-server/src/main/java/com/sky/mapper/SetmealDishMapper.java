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
}
