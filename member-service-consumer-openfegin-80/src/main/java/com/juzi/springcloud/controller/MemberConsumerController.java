package com.juzi.springcloud.controller;

import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.constant.WebConstant;
import com.juzi.springcloud.model.entity.Member;
import com.juzi.springcloud.service.MemberFeignService;
import com.juzi.springcloud.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author codejuzi
 * @CreateTime 2023/4/14
 */
@Slf4j
@RestController
@RequestMapping("/member/consumer")
public class MemberConsumerController {

    @Resource
    private MemberFeignService memberFeignService;


    @GetMapping("/get/{id}")
    public BaseResponse<Member> getMemberById(@PathVariable("id") Long id) {
        return memberFeignService.getMemberById(id);
    }
}
