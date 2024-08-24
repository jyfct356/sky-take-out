package com.sky.service.impl;

import com.sky.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private RedisTemplate redisTemplate;

    private final static String keyStatus = "SHOP_STATUS";

    /**
     * 查询店铺状态
     * @return
     */
    @Override
    public Integer getStatus() {
        return Integer.valueOf((String)redisTemplate.opsForValue().get(keyStatus));
    }

    /**
     * 修改店铺状态
     * @param status
     */
    @Override
    public void updateStatus(String status) {
        redisTemplate.opsForValue().set(keyStatus, status);
    }
}
