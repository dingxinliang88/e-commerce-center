package com.juzi.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codejuzi
 * @CreateTime 2023/4/16
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("/nacos/config")
public class NacosConfigController {

    @Value("${config.ip}")
    private String ip;

    @Value("${config.name}")
    private String name;

    @GetMapping("/name")
    public String getName() {
        return name;
    }

    @GetMapping("/ip")
    public String getIp() {
        return ip;
    }
}
