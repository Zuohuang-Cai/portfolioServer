package org.zuohuang.server.service.impt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.zuohuang.server.mapper.Projectmapper;
import org.zuohuang.server.pojo.DTO.Project;
import org.zuohuang.server.pojo.DTO.Result;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
@Component
public class projectimpt implements org.zuohuang.server.service.Projectservice {
    private final Projectmapper projectmapper;

    @Autowired
    projectimpt(Projectmapper projectmapper) {
        this.projectmapper = projectmapper;
    }

    @Override
    @Transactional
    public void add(Project project) throws IOException {
        project.setFoto(project.getFotofile().getBytes());
        projectmapper.add(project);
        projectmapper.addTags(project);
        log.info("success add project");
    }

    @Override
    public Result Projects() {
        log.info("get all projects");
        return Result.success(projectmapper.Projects());
    }

    @Override
    public Project read(int id) {
        log.info("read a project by id " + id);
        return projectmapper.read(id);
    }

    @Override
    @Transactional
    public void Delete(int id) {
        projectmapper.deleteTags(id);
        projectmapper.deleteProject(id);
        log.info("deleted project by id " + id);
    }

    @Override
    public byte[] foto(Project project) throws SQLException {
        return projectmapper.foto(project).getFoto();
    }

    @Override
    public void update(Project project) {

    }
}
