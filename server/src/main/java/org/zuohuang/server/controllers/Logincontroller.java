package org.zuohuang.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zuohuang.server.pojo.Admin;
import org.zuohuang.server.pojo.Result;
import org.zuohuang.server.service.Loginservice;

@RestController
@RequestMapping("/login")
public class Logincontroller {
    @Autowired
    private Loginservice loginservice;

    @PostMapping("/")
    public Result login(Admin admin) {
        return Result.success(loginservice.login(admin));
    }
}
