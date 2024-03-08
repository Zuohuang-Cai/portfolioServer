package org.zuohuang.server.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AdminLogs {

    @Pointcut("execution(* org.zuohuang.server.controllers.Admincontroller.*(..))")
    public void editLogs() {}

    @Before("editLogs()")
    public void beforeEdit() {
        System.out.println("before edit");
    }

    @After("editLogs()")
    public void afterEdit() {
        System.out.println("after edit");
    }
}
