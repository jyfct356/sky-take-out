package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetmealService {
    /**
     * 根据分类id获取套餐
     * @param categoryId
     * @return
     */
    List<Setmeal> getSetmealByCategoryId(Integer categoryId);

    /**
     * 根据套餐id获取套餐内菜品
     * @param id
     * @return
     */
    List<DishItemVO> getSetmealDishesById(Integer id);

    /**
     * 分页查询套餐
     * @param setmealPageQueryDTO
     * @return
     */
    PageResult getSetmealPage(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    SetmealVO getSetmealById(String id);

    /**
     * 新增套餐
     * @param setmealDTO
     */
    void addSetmeal(SetmealDTO setmealDTO);

    /**
     * 套餐状态起售停售
     * @param status
     * @param id
     */
    void setSetmealStatus(String status, String id);

    /**
     * 批量删除套餐...
     * @param ids
     */
    void deleteSetmealByIds(String ids);

    /**
     * 修改套餐
     * @param setmealDTO
     */
    void updateSetmeal(SetmealDTO setmealDTO);
}
