package org.zuohuang.server.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zuohuang.server.pojo.Admin;
import org.zuohuang.server.pojo.Result;
import org.zuohuang.server.service.Loginservice;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class Logincontroller {
    @Autowired
    private Loginservice loginservice;

    @PostMapping("/")
    public Result login(@RequestBody Admin admin) {
        return Result.success(loginservice.login(admin));
    }

    @GetMapping("/ip")
    public Result ip(HttpServletRequest request) {
        loginservice.ip(request.getRemoteAddr());
        return Result.success();
    }
}
