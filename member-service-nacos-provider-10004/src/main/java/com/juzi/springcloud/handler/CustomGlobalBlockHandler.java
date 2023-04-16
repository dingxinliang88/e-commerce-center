package com.juzi.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author codejuzi
 * @CreateTime 2023/4/16
 */
@Slf4j
public class CustomGlobalBlockHandler {

    public static BaseResponse<?> blockHandler01(BlockException blockException) {
        log.info("query from db failed, exception, ", blockException);
        return ResultUtil.error(400, "===> blockHandler01 <===", "");
    }

    public static BaseResponse<String> blockHandler02(BlockException blockException) {
        log.info("query from db failed, exception: ", blockException);
        return ResultUtil.success("===> blockHandler02 <===");
    }
}
