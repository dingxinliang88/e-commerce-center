package com.juzi.springcloud.controller;

import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.model.entity.Member;
import com.juzi.springcloud.service.MemberService;
import com.juzi.springcloud.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author codejuzi
 * @CreateTime 2023/4/13
 */
@Slf4j
@RestController
@RequestMapping("/member/provider")
public class MemberProviderController {

    @Resource
    private MemberService memberService;

    @PostMapping("/save")
    public BaseResponse<Long> saveMember(@RequestBody Member member) {
        Long memberId = memberService.saveMember(member);
        log.info("save member result: {}", memberId);
        return ResultUtil.success(memberId, "10004 ==> 新增");
    }

    @GetMapping("/get/{id}")
    public BaseResponse<Member> getMemberById(@PathVariable("id") Integer id) {
        Member member = memberService.getById(id);
        log.info("10004 ==> 查询结果：{}", member);
        return ResultUtil.success(member, "10004 ==> 查询");
    }

}
