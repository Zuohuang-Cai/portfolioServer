package org.zuohuang.server.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zuohuang.server.pojo.DTO.Result;

@RestControllerAdvice
public class Exceptionmanager {

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        return Result.fail(e.getMessage());
    }
}