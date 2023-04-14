package com.juzi.springcloud.service;

import com.juzi.springcloud.model.entity.Member;

/**
 * @author codejuzi
 * @description 针对表【member】的数据库操作Service
 * @createDate 2023-04-13 22:35:25
 */
public interface MemberService {

    /**
     * 保存member对象
     *
     * @param member member object
     * @return member id
     */
    Long saveMember(Member member);

    /**
     * 根据 id 查询用户
     *
     * @param id id
     * @return member
     */
    Member getById(Integer id);
}
