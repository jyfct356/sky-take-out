package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品接口")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;

    /**
     * 添加菜品
     * @param dishDTO
     * @return
     */
    @PostMapping("")
    public Result addDish(@RequestBody DishDTO dishDTO) {
        log.info("添加菜品...");
        dishService.addDishWithFlavor(dishDTO);
        return Result.success();
    }

    /**
     * 分页查询菜品
     * @param dishPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result getDishPage(DishPageQueryDTO dishPageQueryDTO) {
        log.info("分页查询菜品...");
        return Result.success(dishService.getDishPage(dishPageQueryDTO));
    }

    /**
     * 起售、停售菜品
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    public Result setDishStatus(@PathVariable("status") Integer status, String id) {
        log.info("起售、停售菜品...");
        dishService.setDishStatus(status, id);
        return Result.success();
    }

    /**
     * 根据id查询菜品
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getDishById(@PathVariable("id") String id) {
        log.info("根据id查询菜品...");
        return Result.success(dishService.getDishById(id));
    }

    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    public Result getDishByCategoryId(Long categoryId) {
        log.info("根据分类id查询菜品...");
        return Result.success(dishService.getDishByCategoryId(categoryId));
    }

    /**
     * 根据id批量删除菜品
     * @param ids
     * @return
     */
    @DeleteMapping("")
    public Result deleteDishByIds(String ids) {
        log.info("根据id批量删除菜品...");
        dishService.deleteDishByIds(ids);
        return Result.success();
    }

    /**
     * 修改菜品
     * @param dishDTO
     * @return
     */
    @PutMapping("")
    public Result updateDish(@RequestBody DishDTO dishDTO) {
        log.info("修改菜品...");
        dishService.updateDish(dishDTO);
        return Result.success();
    }
}
