package com.tensquare.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by CuiJie on 2018/12/13.
 *  统一异常处理类
 * 为了使我们的代码更容易维护，我们创建一个类集中处理异常
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result error(Exception e){
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
