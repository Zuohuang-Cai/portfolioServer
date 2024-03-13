package org.zuohuang.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zuohuang.server.pojo.DTO.Project;
import org.zuohuang.server.pojo.DTO.Result;
import org.zuohuang.server.service.Projectservice;

@RestController
@RequestMapping("/project")
public class Projectcontroller {
    private final Projectservice projectService;

    @Autowired
    Projectcontroller(Projectservice projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/")
    public Result add(Project project) {
        projectService.add(project);
        return Result.success();
    }

    @GetMapping("/Allprojects")
    public Result Projects() {
        return projectService.Projects();
    }

    @GetMapping("/")
    public Result read(int id) {
        return Result.success(projectService.read(id));
    }

    @PutMapping("/")
    public Result edit() {
        return projectService.Projects();
    }

    @DeleteMapping("/")
    public Result delete(int id) {
        projectService.Delete(id);
        return Result.success("success deleted by id " + id);
    }
}
