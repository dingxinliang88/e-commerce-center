package com.juzi.springcloud.mapper;

import com.juzi.springcloud.model.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author codejuzi
 * @description 针对表【member】的数据库操作Mapper
 * @createDate 2023-04-13 22:35:25
 * @Entity com.juzi.springcloud.model.entity.Member
 */
@Mapper
public interface MemberMapper {

    /**
     * 保存member对象到数据库
     *
     * @param member member
     * @return true - insert success
     */
    boolean saveMember(Member member);

    /**
     * 根据id查询member
     *
     * @param id id
     * @return member
     */
    Member getById(Integer id);
}




