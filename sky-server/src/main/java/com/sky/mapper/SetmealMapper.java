package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealMapper {
    /**
     * 根据分类id获取套餐
     * @param categoryId
     * @return
     */
    List<Setmeal> getSetmealByCategoryId(Integer categoryId);

    /**
     * 根据套餐id获取套餐内菜品以及菜品描述
     * @param id
     * @return
     */
    List<DishItemVO> getSetmealDishesWithDescById(Integer id);

    /**
     return null;
     *
     * @param setmealPageQueryDTO
     * @return
     */
    Page<Setmeal> getSetmealPage(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 根据id查询套餐以及所属分类名
     * @param id
     * @return
     */
    SetmealVO getSetmealWithCategoryNameById(String id);



    /**
     * 添加套餐
     * @param setmeal
     */
    @AutoFill(value = OperationType.INSERT)
    void addSetmeal(Setmeal setmeal);


    /**
     * 套餐状态起售停售
     * @param status
     */
    void setSetmealStatus(String status, String id);

    /**
     * 批量删除套餐...
     * @param idArray
     */
    void deleteSetmealByIds(String[] idArray);

    /**
     * 修改套餐信息
     * @param setmeal
     */
    void updateSetmeal(Setmeal setmeal);
}
