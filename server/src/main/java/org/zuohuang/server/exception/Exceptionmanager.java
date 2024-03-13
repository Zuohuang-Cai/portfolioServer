package org.zuohuang.server.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zuohuang.server.pojo.DTO.Result;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestControllerAdvice
public class Exceptionmanager {

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        log.warn(e.getMessage());
        return Result.fail(e.getMessage());
    }
}