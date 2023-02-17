package com.ade.extra.greenway.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    ERROR_LOGIN_USERNAME_NOT_NULL(
            HttpStatus.BAD_REQUEST,
            "ERROR_LOGIN_USERNAME_NOT_NULL",
            "登陆名不能为空"),
    ERROR_LOGIN_USERNAME_NOT_FOUND(
            HttpStatus.BAD_REQUEST,
            "ERROR_LOGIN_USERNAME_NOT_FOUND",
            "登陆名不存在"),
    ERROR_LOGIN_PASSWORD_NOT_NULL(
            HttpStatus.BAD_REQUEST,
            "ERROR_LOGIN_PASSWORD_NOT_NULL",
            "密码不能为空"),
    ERROR_LOGIN_PASSWORD_NOT_MATCH(
            HttpStatus.BAD_REQUEST,
            "ERROR_LOGIN_PASSWORD_NOT_MATCH",
            "密码错误"),

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
