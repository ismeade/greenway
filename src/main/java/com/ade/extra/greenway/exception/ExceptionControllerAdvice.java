package com.ade.extra.greenway.exception;

import com.ade.extra.greenway.common.GeneralResult;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GeneralResult<Void>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(GeneralResult.failed(objectError.getDefaultMessage()));
    }

    /**
     * 处理自定义异常消息
     * @param e 异常
     * @return 通用返回消息
     */
    @ExceptionHandler(ReturnException.class)
    public ResponseEntity<GeneralResult<Void>> returnExceptionHandler(ReturnException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(GeneralResult.failed(e.getMessage())) ;
    }

}
