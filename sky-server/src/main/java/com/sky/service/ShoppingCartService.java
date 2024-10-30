package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    /**
     * 向购物车添加菜品或套餐
     * @param shoppingCartDTO
     */
    void add(ShoppingCartDTO shoppingCartDTO);

    /**
     * 查询当前用户的购物车
     * @return
     */
    List<ShoppingCart> list();

    /**
     * 清空用户购物车
     */
    void clean();

    /**
     * 向购物车删除菜品或套餐
     * @param shoppingCartDTO
     */
    void sub(ShoppingCartDTO shoppingCartDTO);
}
