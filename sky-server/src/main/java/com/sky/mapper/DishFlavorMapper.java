package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface DishFlavorMapper {

    /**
     * 批量添加菜品口味记录
     */
    void addDishFlavors(List<DishFlavor> dishFlavors);

    /**
     * 根据菜品id查询口味
     * @param id
     * @return
     */
    List<DishFlavor> getDishFlavorsByDishId(String id);

    /**
     * 根据id批量删除菜品
     * @param dishIds
     */
    void deleteDishFlavorByDishIds(String[] dishIds);
}
