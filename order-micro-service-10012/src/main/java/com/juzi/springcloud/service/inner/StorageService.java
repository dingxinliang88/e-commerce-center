package com.juzi.springcloud.service.inner;

import com.juzi.springcloud.common.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author codejuzi
 * @CreateTime 2023/4/18
 */
@FeignClient(value = "seata-storage-micro-service")
public interface StorageService {
    /**
     * 扣减库存 （open feign）
     *
     * @param productId product id
     * @param nums      nums
     * @return BaseResponse
     */
    @PostMapping("/reduce")
    BaseResponse<Void> reduce(Long productId, Integer nums);
}
