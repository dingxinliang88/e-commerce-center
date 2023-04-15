package com.juzi.springcloud.service;

import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.model.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author codejuzi
 * @CreateTime 2023/4/15
 */
@Service
@FeignClient(value = "MEMBER-SERVICE-PROVIDER")
public interface MemberFeignService {

    /**
     * 根据id查询member信息
     *
     * @param id member id
     * @return member info
     */
    @GetMapping("/member/provider/get/{id}")
    BaseResponse<Member> getMemberById(@PathVariable("id") Long id);
}
