package com.juzi.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author codejuzi
 * @CreateTime 2023/4/15
 */
@Configuration
public class OpenFeignConfig {

    @Bean
    public Logger.Level logLevel() {
        return Logger.Level.FULL;
    }
}
