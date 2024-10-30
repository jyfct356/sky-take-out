package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/shoppingCart")
@Slf4j
@Api(tags = "购物车相关接口")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 向购物车添加菜品或套餐
     * @param shoppingCartDTO
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("向购物车添加菜品或套餐...");
        shoppingCartService.add(shoppingCartDTO);
        return Result.success();
    }

    /**
     * 查询当前用户的购物车
     * @return
     */
    @GetMapping("/list")
    public Result list() {
        log.info("查询当前用户的购物车...");
        return Result.success(shoppingCartService.list());
    }

    /**
     * 清空用户购物车
     * @return
     */
    @DeleteMapping("/clean")
    public Result clean() {
        log.info("清空用户购物车...");
        shoppingCartService.clean();
        return Result.success();
    }

    /**
     * 向购物车删除菜品或套餐
     * @param shoppingCartDTO
     * @return
     */
    @PostMapping("/sub")
    public Result sub(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("向购物车删除菜品或套餐...");
        shoppingCartService.sub(shoppingCartDTO);
        return Result.success();
    }
}
