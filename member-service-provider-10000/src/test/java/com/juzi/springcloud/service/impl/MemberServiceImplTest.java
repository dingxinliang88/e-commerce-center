package com.juzi.springcloud.service.impl;

import com.juzi.springcloud.model.entity.Member;
import com.juzi.springcloud.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author codejuzi
 * @CreateTime 2023/4/14
 */
@SpringBootTest
class MemberServiceImplTest {

    @Resource
    private MemberService memberService;

    @Test
    void saveMember() {
        Member member = new Member(null, "code", "12345678", "123456", "code@juzi.com", 1);
        Long memberId = memberService.saveMember(member);
        System.out.println("saveMember = " + memberId);
    }

    @Test
    void getById() {
        int id = 1;
        Member member = memberService.getById(id);
        System.out.println("member = " + member);
    }
}