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
import org.zuohuang.server.pojo.DTO.Project;
import org.zuohuang.server.service.Loginservice;
import org.zuohuang.server.service.Logservice;
import org.zuohuang.server.service.Projectservice;
import org.zuohuang.server.utils.Logbuilder;

import java.lang.reflect.Field;
import java.util.HashMap;


@Aspect
@Slf4j
public class ProjectLogs {
    @Autowired
    private Logservice logservice;
    @Autowired
    private Loginservice loginservice;
    @Autowired
    private Projectservice projectservice;

    @Pointcut("execution(* org.zuohuang.server.controllers.Projectcontroller.edit(..))")
    public void editLogs() {
    }

    @Pointcut("execution(* org.zuohuang.server.controllers.Projectcontroller.add(..))")
    public void addLogs() {
    }

    @Pointcut("execution(* org.zuohuang.server.controllers.Projectcontroller.delete(..))")
    public void deleteLogs() {
    }

    @Pointcut("execution(* org.zuohuang.server.controllers.Projectcontroller.read(..))")
    public void readtLogs() {
    }

    @Before("deleteLogs()")
    public void beforeDelete(JoinPoint joinPoint) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("start delete");
        store(joinPoint, "Delete");
    }

    @Before("readtLogs()")
    public void beforeRead(JoinPoint joinPoint) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("start read");
        store(joinPoint, "Read");
    }

    @Before("addLogs()")
    public void beforeAdd(JoinPoint joinPoint) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("start add");
        store(joinPoint, "Add");
    }

    @Before("editLogs()")
    public void beforeEdit(JoinPoint joinPoint) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("start edit");
        store(joinPoint, "Edit");
    }

    private void store(JoinPoint joinPoint, String Type) throws NoSuchFieldException, IllegalAccessException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HashMap<String, Object> admin = getAdmin(request);
        Object[] args = joinPoint.getArgs();

        Field id = args[0].getClass().getDeclaredField("id");
        id.setAccessible(true);

        Field Title = args[0].getClass().getDeclaredField("Title");
        Title.setAccessible(true);

        Project project = new Project();
        project.setId((long) id.get(args[0]));
        if (project.getId() != 0) {
            project = projectservice.read(project);
        }
        project.setTitle((String) Title.get(args[0]));
        Logbuilder logbuilder = new Logbuilder()
                .setAdminId((int) admin.get("id"))
                .setInfo(admin.get("name") + " " + Type.toLowerCase() + " " + project.getTitle() + " from " + request.getRemoteAddr())
                .setType(Type);
        logservice.editlogs(logbuilder.build());
    }

    private HashMap<String, Object> getAdmin(HttpServletRequest request) {
        String token = request.getHeader("token");
        return loginservice.getClaims(token);
    }

    @After("editLogs()")
    public void afterEdit() {
        log.info("success edited");
    }

    @After("addLogs()")
    public void afterAdd() {
        log.info("success added");
    }

    @After("deleteLogs()")
    public void afterDelete() {
        log.info("success deleted");
    }

    @After("readtLogs()")
    public void afterRead() {
        log.info("success read");
    }

}
