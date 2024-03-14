package org.zuohuang.server.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.zuohuang.server.pojo.DTO.Log;
import org.zuohuang.server.service.Adminservice;
import org.zuohuang.server.service.Loginservice;
import org.zuohuang.server.service.Logservice;

import java.util.HashMap;


@Aspect
@Slf4j
public class ProjectLogs {
    @Autowired
    private Logservice logservice;
    @Autowired
    private Loginservice loginservice;

    @Pointcut("execution(* org.zuohuang.server.controllers.Projectcontroller.edit(..))")
    public void editLogs() {
    }

    @Before("editLogs()")
    public void beforeEdit(JoinPoint joinPoint) {
        Object args[] = joinPoint.getArgs();

        for (Object arg : args) {
            System.out.println("Method argument value: " + arg);
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        Log log = new Log();
        HashMap<String, Object> admin = loginservice.getClaims(token);
        log.setAdmin_id((int) admin.get("id"));
        log.setType("Edit");
        log.setInfo(admin.get("name") + " edited the project from" + request.getRemoteAddr());
        logservice.editlogs(log);
        loginservice.getClaims(token);
    }

    @After("editLogs()")
    public void afterEdit() {
        log.info("success edited");
    }
}
