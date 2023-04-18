package com.juzi.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
public interface AccountService {

    /**
     * 扣减账户余额
     *
     * @param userId userId
     * @param money  money
     */
    void reduce(@RequestParam("userId") Long userId, @RequestParam("money") Integer money);
}
