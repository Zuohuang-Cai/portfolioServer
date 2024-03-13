package org.zuohuang.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zuohuang.server.pojo.DTO.Admin;
import org.zuohuang.server.pojo.DTO.Result;
import org.zuohuang.server.service.Adminservice;


@RestController
@RequestMapping("/admin")
public class Admincontroller {
    @Autowired
    private Adminservice adminservice;

    @PostMapping("/")
    public Result Create(Admin admin) {
        adminservice.create(admin);
        return Result.success();
    }


}
