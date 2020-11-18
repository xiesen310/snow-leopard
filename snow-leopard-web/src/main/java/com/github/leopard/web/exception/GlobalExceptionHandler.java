package com.github.leopard.web.exception;

import com.github.leopard.web.reponse.ResponseHelper;
import com.github.leopard.web.reponse.ResponseModel;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @author 谢森
 * @Description 全局异常处理
 * @Email xiesen310@163.com
 * @Date 2020/11/18 20:03
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * post请求参数校验抛出的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseModel methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        //获取异常中随机一个异常信息
        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseHelper.validationFailure(defaultMessage);
    }

    /**
     * get请求参数校验抛出的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseModel bindExceptionHandler(BindException e) {
        //获取异常中随机一个异常信息
        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseHelper.validationFailure(defaultMessage);
    }

    /**
     * 请求方法中校验抛出的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseModel constraintViolationExceptionHandler(ConstraintViolationException e) {
        //获取异常中第一个错误信息
        String message = e.getConstraintViolations().iterator().next().getMessage();
        return ResponseHelper.validationFailure(message);
    }
}
