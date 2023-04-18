package com.juzi.springcloud.controller;

import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.service.AccountService;
import com.juzi.springcloud.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
@Slf4j
@RequestMapping("/account")
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/reduce")
    public BaseResponse<Void> reduce(@RequestParam("userId") Long userId, @RequestParam("money") Integer money) {
        accountService.reduce(userId, money);
        return ResultUtil.success(null, "扣减金额成功 ok");
    }
}
