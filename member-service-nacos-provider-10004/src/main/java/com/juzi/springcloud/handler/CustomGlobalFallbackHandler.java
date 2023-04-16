package com.juzi.springcloud.handler;

import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author codejuzi
 * @CreateTime 2023/4/16
 */
@Slf4j
public class CustomGlobalFallbackHandler {

    public static BaseResponse<?> fallbackHandler01(Throwable t) {
        return ResultUtil.error(400, t.getMessage(), "");
    }
}
