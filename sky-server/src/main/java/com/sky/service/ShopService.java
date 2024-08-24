package com.sky.service;

public interface ShopService {
    /**
     * 查询店铺状态
     * @return
     */
    Integer getStatus();

    /**
     * 修改店铺状态
     * @param status
     */
    void updateStatus(String status);
}
