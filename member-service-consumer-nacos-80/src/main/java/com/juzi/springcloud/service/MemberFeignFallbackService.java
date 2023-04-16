package com.juzi.springcloud.service;

import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.model.entity.Member;
import com.juzi.springcloud.utils.ResultUtil;
import org.springframework.stereotype.Component;

/**
 * @author codejuzi
 * @CreateTime 2023/4/16
 */
@Component
public class MemberFeignFallbackService implements MemberOpenFeignService{
    @Override
    public BaseResponse<Member> getMemberById(Long id) {
        return ResultUtil.success(null, "服务被熔断降级……");
    }

    @Override
    public BaseResponse<Long> saveMember(Member member) {
        return ResultUtil.success(null, "服务被熔断降级……");
    }
}
