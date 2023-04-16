package com.juzi.springcloud.controller;

import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.model.entity.Member;
import com.juzi.springcloud.service.MemberOpenFeignService;
import com.juzi.springcloud.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author codejuzi
 * @CreateTime 2023/4/14
 */
@Slf4j
@RestController
@RequestMapping("/member/openfeign/consumer")
public class MemberConsumerController {

    @Resource
    private MemberOpenFeignService memberOpenFeignService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/save")
    public BaseResponse<Long> memberSave(@RequestBody Member member) {
        return memberOpenFeignService.saveMember(member);
    }


    @GetMapping("/get/{id}")
    public BaseResponse<Member> getMemberById(@PathVariable("id") Long id) {
        log.info("open feign ==> getMemberById: {}", id);
        return memberOpenFeignService.getMemberById(id);
    }

    @GetMapping("/discovery")
    public BaseResponse<Object> discovery() {
        for (String service : discoveryClient.getServices()) {
            log.info("<==============服务名：{}==============>", service);
            for (ServiceInstance instance : discoveryClient.getInstances(service)) {
                log.info("serviceId: {}, instantId: {}, host: {}, port: {}, uri: {}",
                        instance.getServiceId(),
                        instance.getInstanceId(),
                        instance.getHost(),
                        instance.getPort(),
                        instance.getUri());
            }
        }
        return ResultUtil.success(discoveryClient);
    }
}
