package org.zuohuang.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zuohuang.server.pojo.Admin;
import org.zuohuang.server.pojo.Result;
import org.zuohuang.server.service.Adminservice;


@RestController
@RequestMapping("/api")
public class Admincontroller {
    @Autowired
    private Adminservice adminservice;

    @PostMapping("/admin")
    public Result Create(Admin admin) {
        adminservice.create(admin);
        return Result.success();
    }

    @PutMapping("/admin")
    public Result update(@RequestBody Admin data) {
        System.out.println(data);
        System.out.println(data.getClass().getName());
        adminservice.update(data);
        return Result.success();
    }

    @GetMapping("/verify")
    public Result verify() {
        return Result.success();
    }
}
