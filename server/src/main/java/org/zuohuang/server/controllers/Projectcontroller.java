package org.zuohuang.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zuohuang.server.pojo.DTO.Project;
import org.zuohuang.server.pojo.DTO.Result;
import org.zuohuang.server.service.Projectservice;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.SQLException;

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

    @GetMapping("/foto")
    public ResponseEntity<byte[]> foto(Project project) throws SQLException, IOException {
        byte[] fotoData = projectService.foto(project).getBytes();
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/octet-stream")
                .body(fotoData);
    }
}
