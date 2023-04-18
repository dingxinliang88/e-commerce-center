package com.juzi.springcloud.service.impl;

import com.juzi.springcloud.mapper.OrderMapper;
import com.juzi.springcloud.model.entity.Order;
import com.juzi.springcloud.service.OrderService;
import com.juzi.springcloud.service.inner.AccountService;
import com.juzi.springcloud.service.inner.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    @GlobalTransactional(name = "codejuzi-order-save", rollbackFor = Exception.class)
    public void save(Order order) {
        log.info("=========开始新建订单 start ==========");
        //新建订单
        orderMapper.save(order);
        System.out.println("order=" + order);
        log.info("=========减库存 start ==========");
        storageService.reduce(order.getProductId(), order.getNums());
        log.info("=========减库存 end ==========");
        log.info("=========减账户金额 start ==========");
        accountService.reduce(order.getUserId(), order.getMoney());
        log.info("=========减账户金额 end ==========");
        log.info("=========修改订单状态 start ==========");
        orderMapper.update(order.getUserId(), 0);
        log.info("=========修改订单状态 end ==========");
        log.info("=========下订单 end==========");
    }
}
