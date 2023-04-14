package com.juzi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author codejuzi
 * @CreateTime 2023/4/13
 */
@EnableEurekaClient
@SpringBootApplication
public class MemberProviderApplication10002 {

    public static void main(String[] args) {
        SpringApplication.run(MemberProviderApplication10002.class, args);
    }
}
