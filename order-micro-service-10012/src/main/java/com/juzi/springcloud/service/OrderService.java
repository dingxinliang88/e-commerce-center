package com.juzi.springcloud.service;

import com.juzi.springcloud.model.entity.Order;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
public interface OrderService {

    /**
     * 保存订单
     *
     * @param order order
     */
    void save(Order order);
}
