package org.zuohuang.server.controllers;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zuohuang.server.pojo.Admin;
import org.zuohuang.server.pojo.Result;
import org.zuohuang.server.service.Loginservice;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping("/login")
public class Logincontroller {
    @Autowired
    private Loginservice loginservice;

    @PostMapping("/")
    public Result login(@RequestBody Admin admin, HttpServletResponse response) {
        if (loginservice.login(admin).equals("null")) {
            response.setStatus(400);
            return Result.fail("wrong username or password");
        }
        return Result.success(loginservice.login(admin));
    }

    @GetMapping("/")
    public Result verify(String token, HttpServletResponse response) {
        if (loginservice.verify(token)) {
            return Result.success();
        }
        response.setStatus(400);
        return Result.fail("invalid token");
    }


    @GetMapping("/ip")
    public Result ip(HttpServletRequest request) {
        loginservice.ip(request.getRemoteAddr());
        return Result.success();
    }
}
