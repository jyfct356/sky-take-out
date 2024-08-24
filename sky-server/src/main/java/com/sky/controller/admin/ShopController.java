package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.ShopService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("adminShopController")
@RequestMapping("/admin/shop")
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
        log.info("查询店铺状态...");
        return Result.success(shopService.getStatus());
    }

    /**
     * 修改店铺状态
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    public Result updateStatus(@PathVariable("status") String status) {
        log.info("修改店铺状态...");
        shopService.updateStatus(status);
        return Result.success();
    }
}
