package com.ade.extra.greenway.common;

import lombok.Data;

@Data
public class GeneralResult<T> {

    private String code;
    private String error;
    private T data;

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> GeneralResult<T> success(T data) {
        GeneralResult<T> generalResult = new GeneralResult<>();
        generalResult.setCode("SUCCESS");
        generalResult.setData(data);
        return generalResult;
    }

    /**
     *
     * 失败返回结果
     *
     * @param code 错误码
     * @param error 错误描述
     */
    public static <T> GeneralResult<T> failed(String code, String error) {
        GeneralResult<T> generalResult = new GeneralResult<>();
        generalResult.setCode(code);
        generalResult.setError(error);
        return generalResult;
    }

    /**
     * 失败返回结果
     *
     * @param error 错误信息
     */
    public static <T> GeneralResult<T> failed(String error) {
        GeneralResult<T> generalResult = new GeneralResult<>();
        generalResult.setCode("ERROR");
        generalResult.setError(error);
        return generalResult;
    }

}