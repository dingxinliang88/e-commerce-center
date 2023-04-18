package com.juzi.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
@Mapper
public interface StorageMapper {
    /**
     * 扣减库存信息
     *
     * @param productId 产品id
     * @param nums      扣件数量
     */
    void reduce(@Param("productId") Long productId, @Param("nums") Integer nums);
}
