package com.ade.extra.greenway.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ErrorMessage {

    private String error;

    /**
     *
     * 失败返回结果
     *
     * @param errorCode 错误描述
     */
    public static ErrorMessage failed(ErrorCode errorCode) {
        return ErrorMessage.builder().error(errorCode.getMessage()).build();
    }

    /**
     * 失败返回结果
     *
     * @param error 错误信息
     */
    public static ErrorMessage failed(String error) {
        return ErrorMessage.builder().error(error).build();
    }

}