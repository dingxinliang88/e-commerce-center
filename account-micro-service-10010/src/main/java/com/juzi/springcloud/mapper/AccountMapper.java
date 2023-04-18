package com.juzi.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
@Mapper
public interface AccountMapper {
    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money 金额
     */
    void reduce(@Param("userId") Long userId, @Param("money") Integer money);
}
