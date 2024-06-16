package org.zuohuang.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zuohuang.server.pojo.DTO.Project;
import org.zuohuang.server.pojo.DTO.Result;
import org.zuohuang.server.service.Projectservice;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "*")
public class Projectcontroller {
    private final Projectservice projectService;

    @Autowired
    Projectcontroller(Projectservice projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/")
    public Result add(Project project) throws IOException {
        projectService.add(project);
        return Result.success();
    }

    @GetMapping("/Allprojects")
    public Result Projects() {
        return projectService.Projects();
    }

    @GetMapping("/")
    public Result read(Project project) throws SQLException {
        return Result.success(projectService.read(project));
    }

    @PutMapping("/")
    public Result edit(Project project) {
        projectService.update(project);
        return Result.success();
    }

    @DeleteMapping("/")
    public Result delete(Project project) {
        projectService.Delete(project);
        return Result.success("success deleted by id " + project.getId());
    }

    @GetMapping("/foto")
    public ResponseEntity<ByteArrayResource> foto(Project project) throws SQLException, IOException {
        byte[] fotoData = projectService.foto(project);
        ByteArrayResource resource = new ByteArrayResource(fotoData);
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType("image/jpeg"))
                .body(resource);
    }
}
