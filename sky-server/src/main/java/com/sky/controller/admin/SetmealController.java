package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("adminSetmealController")
@RequestMapping("/admin/setmeal")
@Slf4j
@Api(tags = "套餐接口")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 分页查询套餐
     * @param setmealPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result getSetmealPage(SetmealPageQueryDTO setmealPageQueryDTO) {
        log.info("分页查询套餐...");
        return Result.success(setmealService.getSetmealPage(setmealPageQueryDTO));
    }

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getSetmealById(@PathVariable("id") String id) {
        log.info("根据id查询套餐...");
        return Result.success(setmealService.getSetmealById(id));
    }

    /**
     * 新增套餐
     * @param setmealDTO
     * @return
     */
    @PostMapping("")
    @CacheEvict(cacheNames = "setmealCache", key = "#setmealDTO.categoryId")
    public Result addSetmeal(@RequestBody SetmealDTO setmealDTO) {
        log.info("新增套餐...");
        setmealService.addSetmeal(setmealDTO);
        return Result.success();
    }

    /**
     * 套餐状态起售停售
     * @param status
     * @return
     */
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)
    @PostMapping("/status/{status}")
    public Result setSetmealStatus(@PathVariable("status") String status, String id) {
        log.info("套餐起售停售...");
        setmealService.setSetmealStatus(status, id);
        return Result.success();
    }

    /**
     * 批量删除套餐...
     * @param ids
     * @return
     */
    @DeleteMapping("")
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)
    public Result deleteSetmealByIds(String ids) {
        log.info("批量删除套餐...");
        setmealService.deleteSetmealByIds(ids);
        return Result.success();
    }

    /**
     * 修改套餐
     * @param setmealDTO
     * @return
     */
    @PutMapping("")
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)
    public Result updateSetmeal(@RequestBody SetmealDTO setmealDTO) {
        log.info("修改套餐...");
        setmealService.updateSetmeal(setmealDTO);
        return Result.success();
    }

}
