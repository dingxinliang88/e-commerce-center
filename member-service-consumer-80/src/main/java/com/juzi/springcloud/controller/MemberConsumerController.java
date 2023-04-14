package com.juzi.springcloud.controller;

import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.constant.WebConstant;
import com.juzi.springcloud.model.entity.Member;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author codejuzi
 * @CreateTime 2023/4/14
 */
@RestController
@RequestMapping("/member/consumer")
public class MemberConsumerController {

    @Resource
    private RestTemplate restTemplate;

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
}
