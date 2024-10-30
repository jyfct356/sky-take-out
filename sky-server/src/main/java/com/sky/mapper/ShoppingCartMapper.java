package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    /**
     * 查询购物车记录
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 插入一条购物车记录
     * @param shoppingCart
     */
    void add(ShoppingCart shoppingCart);


    /**
     * 修改购物车记录
     * @param shoppingCart
     */
    void update(ShoppingCart shoppingCart);

    /**
     * 清空用户购物车
     *
     * @param shoppingCart
     */
    void delete(ShoppingCart shoppingCart);
}
