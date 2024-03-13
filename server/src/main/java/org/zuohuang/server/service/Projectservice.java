package org.zuohuang.server.service;

import org.zuohuang.server.pojo.DTO.Project;
import org.zuohuang.server.pojo.DTO.Result;

public interface Projectservice {
    void add(Project project);

    Result Projects();
}
