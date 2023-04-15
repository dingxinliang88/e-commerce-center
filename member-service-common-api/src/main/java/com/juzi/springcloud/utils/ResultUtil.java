package com.juzi.springcloud.utils;


import com.juzi.springcloud.common.BaseResponse;
import com.juzi.springcloud.common.ErrorCode;

/**
 * 返回结果工具类
 *
 * @author codejuzi
 * @CreateTime 2023/4/5
 */
public class ResultUtil {

    /**
     * 成功
     *
     * @param data 成功后的响应结果
     * @param <T>  泛型
     * @return BasesResponse
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(ErrorCode.SUCCESS.getCode(), data, "");
    }

    /**
     * 成功
     *
     * @param data    成功后的响应结果
     * @param message 成功消息
     * @param <T>     泛型
     * @return BaseResponse
     */
    public static <T> BaseResponse<T> success(T data, String message) {
        return new BaseResponse<>(ErrorCode.SUCCESS.getCode(), data, message);
    }

    /**
     * 失败
     *
     * @param code        code
     * @param message     message
     * @param description desc
     * @return BasesResponse
     */
    public static BaseResponse<?> error(int code, String message, String description) {
        return new BaseResponse<>(code, null, message, description);
    }

    /**
     * 失败
     *
     * @param errorCode   error code
     * @param message     message
     * @param description desc
     * @return BasesResponse
     */
    public static BaseResponse<?> error(ErrorCode errorCode, String message, String description) {
        return new BaseResponse<>(errorCode.getCode(), null, message, description);
    }

}
