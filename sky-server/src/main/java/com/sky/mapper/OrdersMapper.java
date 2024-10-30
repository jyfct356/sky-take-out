package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper {
    /**
     * 插入一条订单记录
     * @param orders
     */
    void add(Orders orders);
}
