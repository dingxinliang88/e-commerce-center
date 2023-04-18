package com.juzi.springcloud.service.impl;

import com.juzi.springcloud.mapper.StorageMapper;
import com.juzi.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void reduce(Long productId, Integer nums) {
        log.info("==========seata_storage_micro_service-10011 扣 减 库 存 start==========");
        storageMapper.reduce(productId, nums);
        log.info("==========seata_storage_micro_service-10011 扣 减 库 存 end==========");
    }
}
}
