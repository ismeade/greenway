package com.ade.extra.greenway.exception;

import org.springframework.http.HttpStatus;

import java.util.Optional;

/**
 * 自定义异常
 */
public class ReturnException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    protected HttpStatus httpStatus;
    protected ErrorMessage errorMessage;

    public ReturnException(HttpStatus httpStatus, String error) {
        this.httpStatus = httpStatus;
        this.errorMessage = ErrorMessage.failed(error);
    }

    public ReturnException(String error) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, error);

    }

    public ReturnException(ErrorCode errorCode) {
        this(errorCode.getHttpStatus(), errorCode.getMessage());
    }

    public ReturnException() {
        this("系统内部错误");
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return Optional.ofNullable(this.errorMessage)
                .map(ErrorMessage::getError)
                .orElse("");
    }

}
