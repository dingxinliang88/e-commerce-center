package com.juzi.springcloud.controller;

import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.constant.WebConstant;
import com.juzi.springcloud.model.entity.Member;
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
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/save")
    public BaseResponse<?> memberSave(@RequestBody Member member) {
        String url = WebConstant.MEMBER_PROVIDER_URL_PREFIX + "/save";
        return restTemplate.postForObject(url, member, BaseResponse.class);
    }


    @GetMapping("/get/{id}")
    public BaseResponse<?> getMemberById(@PathVariable("id") Long id) {
        String url = WebConstant.MEMBER_PROVIDER_URL_PREFIX + "/get/" + id;
        return restTemplate.getForObject(url, BaseResponse.class);
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
