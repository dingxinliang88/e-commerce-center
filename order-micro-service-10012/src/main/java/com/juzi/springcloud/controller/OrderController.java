package com.juzi.springcloud.controller;

import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.model.entity.Order;
import com.juzi.springcloud.service.OrderService;
import com.juzi.springcloud.service.inner.AccountService;
import com.juzi.springcloud.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
@Slf4j
@RequestMapping("/order")
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/save")
    public BaseResponse<Void> save(@RequestBody Order order) {
        orderService.save(order);
        return ResultUtil.success(null, "扣减金额成功 ok");
    }
}
