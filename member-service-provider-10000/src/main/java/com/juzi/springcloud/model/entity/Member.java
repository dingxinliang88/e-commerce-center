package com.juzi.springcloud.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author codejuzi
 * @TableName member
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别，1 - 男，0 - 女
     */
    private Integer gender;

    private static final long serialVersionUID = 1L;
}