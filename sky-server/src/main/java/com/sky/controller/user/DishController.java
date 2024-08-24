package com.sky.controller.user;

import com.sky.constant.RedisConstant;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("userDishController")
@RequestMapping("/user/dish")
@Api(tags = "菜品接口")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    public Result getDishByCategoryId(Long categoryId) {
        log.info("根据分类id查询菜品...");
        String key = RedisConstant.REDIS_CATEGORY_PREFIX + categoryId;
        List<Dish> list = (List<Dish>) redisTemplate.opsForValue().get(key);
        if (list != null && list.size() > 0) {
            return Result.success(list);
        }
        list = dishService.getDishByCategoryId(categoryId);
        if (list != null && list.size() > 0) {

            redisTemplate.opsForValue().set(key, list);
        }
        return Result.success(list);
    }


}
