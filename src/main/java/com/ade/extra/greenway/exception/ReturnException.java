package com.ade.extra.greenway.exception;

import org.springframework.http.HttpStatus;

/**
 * 自定义异常
 */
public class ReturnException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    protected HttpStatus httpStatus;
    protected String code;
    protected String message;

    public ReturnException(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public ReturnException(String message) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, "SYSTEM_ERROR", message);

    }

    public ReturnException(ErrorCode errorCode) {
        this(errorCode.getHttpStatus(), errorCode.getCode(), errorCode.getMessage());
    }

    public ReturnException() {
        this("系统内部错误");
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
