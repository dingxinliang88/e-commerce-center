package com.juzi.springcloud.mapper;

import com.juzi.springcloud.model.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
@Mapper
public interface OrderMapper {
    /**
     * 新建订单
     *
     * @param order order
     */
    void save(Order order);

    /**
     * update
     *
     * @param userId user id
     * @param status status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
