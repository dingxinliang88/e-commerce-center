package com.juzi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author codejuzi
 * @CreateTime 2023/4/13
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MemberProviderApplication10004 {

    public static void main(String[] args) {
        SpringApplication.run(MemberProviderApplication10004.class, args);
    }
}
