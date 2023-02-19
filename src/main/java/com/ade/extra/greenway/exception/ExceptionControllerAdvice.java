package com.ade.extra.greenway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常错误统一消息处理类
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {


    /**
     * 参数错误
     * @param e 异常
     * @return 返回信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessage.failed(objectError.getDefaultMessage()));
    }

    /**
     * 业务异常
     * @param e 异常
     * @return 返回消息
     */
    @ExceptionHandler(ReturnException.class)
    public ResponseEntity<ErrorMessage> returnExceptionHandler(ReturnException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(ErrorMessage.failed(e.getMessage())) ;
    }

}
