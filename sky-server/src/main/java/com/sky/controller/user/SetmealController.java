package com.sky.controller.user;

import com.sky.result.Result;
import com.sky.service.SetmealService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController("userSetmealController")
@RequestMapping("/user/setmeal")
@Slf4j
@Api(tags = "套餐接口")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;

    /**
     * 根据分类id获取套餐
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @Cacheable(cacheNames = "setmealCache", key = "#categoryId")
    public Result getSetmealByCategoryId(Integer categoryId) {
        log.info("根据分类id获取套餐:{}", categoryId);
        return Result.success(setmealService.getSetmealByCategoryId(categoryId));
    }

    /**
     * 根据套餐id获取套餐内菜品
     * @param id
     * @return
     */
    @GetMapping("/dish/{id}")
    public Result getSetmealDishesById(@PathVariable Integer id) {
        log.info("根据套餐id获取套餐内菜品...");
        return Result.success(setmealService.getSetmealDishesById(id));
    }
}
