package com.sky.controller.user;

import com.sky.dto.OrdersDTO;
import com.sky.dto.OrdersSubmitDTO;
import com.sky.result.Result;
import com.sky.service.OrdersService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/order")
@Slf4j
@Api(tags = "订单相关接口")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 用户 下单
     * @param ordersSubmitDTO
     * @return
     */
    @PostMapping("/submit")
    public Result submit(@RequestBody OrdersSubmitDTO ordersSubmitDTO) {
        log.info("用户 下单...");
        return Result.success(ordersService.submit(ordersSubmitDTO));
    }
}
