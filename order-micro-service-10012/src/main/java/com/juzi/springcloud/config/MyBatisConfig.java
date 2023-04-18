package com.juzi.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
@Configuration
@MapperScan({"com.juzi.springcloud.mapper"})
public class MyBatisConfig {
}
