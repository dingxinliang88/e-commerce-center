package com.juzi.springcloud.service;

import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.model.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author codejuzi
 * @CreateTime 2023/4/16
 */
@Service
@FeignClient(value = "member-service-nacos-provider", fallback = MemberFeignFallbackService.class)
public interface MemberOpenFeignService {

    /**
     * 根据 id 查询member
     *
     * @param id member id
     * @return member info
     */
    @GetMapping("/member/provider/get/{id}")
    BaseResponse<Member> getMemberById(@PathVariable("id") Long id);

    /**
     * save member
     *
     * @param member member info
     * @return member id
     */
    @PostMapping("/member/provider/save")
    BaseResponse<Long> saveMember(Member member);
}
