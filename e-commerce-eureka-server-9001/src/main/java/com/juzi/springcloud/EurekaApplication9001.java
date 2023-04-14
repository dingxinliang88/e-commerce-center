package com.juzi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author codejuzi
 * @CreateTime 2023/4/14
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication9001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication9001.class, args);
    }
}
