package org.zuohuang.server.service.impt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zuohuang.server.mapper.Projectmapper;
import org.zuohuang.server.pojo.DTO.Project;
import org.zuohuang.server.pojo.DTO.Result;
import org.zuohuang.server.service.Projectservice;

@Service
@Slf4j
@Component
public class projectimpt implements Projectservice {
    private final Projectmapper projectmapper;

    @Autowired
    projectimpt(Projectmapper projectmapper) {
        this.projectmapper = projectmapper;
    }

    @Override
    @Transactional
    public void add(Project project) {
        projectmapper.add(project);
        projectmapper.addTags(project);
        log.info("success add project");
    }

    @Override
    public Result Projects() {
        return Result.success(projectmapper.Projects());
    }
}
