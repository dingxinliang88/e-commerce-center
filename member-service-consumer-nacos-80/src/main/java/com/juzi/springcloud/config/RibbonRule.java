package com.juzi.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author codejuzi
 * @CreateTime 2023/4/16
 */
@Configuration
public class RibbonRule {

    @Bean
    public IRule myRibbonRule() {
        return new RandomRule();
    }
}
