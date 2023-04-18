package com.juzi.springcloud.service.impl;

import com.juzi.springcloud.mapper.AccountMapper;
import com.juzi.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;


    @Override
    public void reduce(Long userId, Integer money) {
        log.info("========seata_account_micro_service-10010 扣减账户余额 start ======");
        accountMapper.reduce(userId, money);
        log.info("========seata_account_micro_service-10010 扣减账户余额 end ======");
    }
}
