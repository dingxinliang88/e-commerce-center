package com.juzi.springcloud.controller;

import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.service.StorageService;
import com.juzi.springcloud.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
@Slf4j
@RequestMapping("/storage")
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/reduce")
    public BaseResponse<Void> reduce(Long productId, Integer nums) {
        storageService.reduce(productId, nums);
        return ResultUtil.success(null, "扣减库存成功 ok");
    }
}
