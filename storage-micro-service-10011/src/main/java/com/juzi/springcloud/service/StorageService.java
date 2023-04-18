package com.juzi.springcloud.service;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
public interface StorageService {

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param nums      扣减数
     */
    void reduce(Long productId, Integer nums);
}
