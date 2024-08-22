package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /**
     * 添加一条分类记录
     * @param category
     */
    @AutoFill(value = OperationType.INSERT)
    void addCategory(Category category);

    /**
     * 分页查询分类记录
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> getCategoryPage(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 根据id删除分类
     * @param id
     */
    void deleteCategoryById(String id);

    /**
     * 修改分类
     * @param category
     */
    @AutoFill(value = OperationType.UPDATE)
    void updateCategory(Category category);

    /**
     * 启用禁用分类
     * @param status
     * @param id
     */
    void setCategoryStatus(String status, String id);

    /**
     * 根据type查询分类
     * @param type
     * @return
     */
    List<Category> getCategoryByType(String type);
}
