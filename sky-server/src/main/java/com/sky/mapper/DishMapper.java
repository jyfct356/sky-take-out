package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishMapper {
    /**
     * 添加一条菜品记录
     * @param dish
     */
    @AutoFill(value = OperationType.INSERT)
    void addDish(Dish dish);

    /**
     * 分页查询菜品
     * @param dishPageQueryDTO
     * @return
     */
    Page<DishVO> getDishPage(DishPageQueryDTO dishPageQueryDTO);

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
     return List.of();
     *
     * @param categoryId
     * @return
     */
    List<Dish> getDishByCategoryId(Long categoryId);

    /**
     * 根据id批量删除菜品
     * @param ids
     */
    void deleteDishByIds(String[] ids);

    /**
     * 通过id获取菜品售卖状态
     * @param ids
     * @return
     */
    List<Integer> getStatusByIds(String[] ids);

    /**
     * 修改菜品
     * @param dishDTO
     */
    void updateDish(DishDTO dishDTO);
}
