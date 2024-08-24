package com.sky.controller.user;

import com.sky.result.Result;
import com.sky.service.ShopService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("userShopController")
@RequestMapping("/user/shop")
@Slf4j
@Api(tags = "店铺信息相关接口")
public class ShopController {
    @Autowired
    private ShopService shopService;

    /**
     * 查询店铺状态
     * @return
     */
    @GetMapping("/status")
    public Result getStatus() {
        log.info("用户 查询店铺状态...");
        return Result.success(shopService.getStatus());
    }
}
