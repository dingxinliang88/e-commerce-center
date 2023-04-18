package com.juzi.springcloud.service.inner;

import com.juzi.springcloud.common.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
@FeignClient(value = "seata-account-micro-service")
public interface AccountService {
    /**
     * 扣减金额（open feign）
     *
     * @param userId user id
     * @param money  money
     * @return BaseResponse
     */
    @PostMapping("/reduce")
    BaseResponse<Void> reduce(@RequestParam("userId") Long userId, @RequestParam("money") Integer money);
}
