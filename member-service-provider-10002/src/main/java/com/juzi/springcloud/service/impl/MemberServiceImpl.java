package com.juzi.springcloud.service.impl;

import com.juzi.springcloud.mapper.MemberMapper;
import com.juzi.springcloud.model.entity.Member;
import com.juzi.springcloud.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author codejuzi
 * @description 针对表【member】的数据库操作Service实现
 * @createDate 2023-04-13 22:35:25
 */
@Service
public class MemberServiceImpl
        implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public Long saveMember(Member member) {

        memberMapper.saveMember(member);
        return member.getId();
    }

    @Override
    public Member getById(Integer id) {

        return memberMapper.getById(id);
    }
}




