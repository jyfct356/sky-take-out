package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类接口")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 添加分类
     * @param categoryDTO
     * @return
     */
    @PostMapping("")
    public Result addCategory(@RequestBody CategoryDTO categoryDTO) {
        log.info("添加分类...");
        categoryService.addCategory(categoryDTO);
        return Result.success();
    }

    /**
     * 分页查询分类
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result getCategoryPage(CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("分页查询分类...");
        return Result.success(categoryService.getCategoryPage(categoryPageQueryDTO));
    }

    /**
     * 根据id删除分类
     * @param id
     * @return
     */
    @DeleteMapping("")
    public Result deleteCategoryById(String id) {
        log.info("根据id删除分类...");
        categoryService.deleteCategoryById(id);
        return Result.success();
    }

    /**
     * 修改分类
     * @param categoryDTO
     * @return
     */
    @PutMapping("")
    public Result updateCategory(@RequestBody CategoryDTO categoryDTO) {
        log.info("修改分类...");
        categoryService.updateCategory(categoryDTO);
        return Result.success();
    }

    /**
     * 启用禁用分类
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    public Result setCategoryStatus(@PathVariable("status") String status, String id) {
        log.info("启用禁用分类...");
        categoryService.setCategoryStatus(status, id);
        return Result.success();
    }

    /**
     * 根据type查询分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    public Result getCategoryByType(String type) {
        log.info("根据type查询分类...");
        return Result.success(categoryService.getCategoryByType(type));
    }

}
