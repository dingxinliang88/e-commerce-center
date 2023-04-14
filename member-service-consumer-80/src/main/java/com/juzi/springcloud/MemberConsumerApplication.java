package com.juzi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author codejuzi
 * @CreateTime 2023/4/14
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MemberConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberConsumerApplication.class, args);
    }
}
