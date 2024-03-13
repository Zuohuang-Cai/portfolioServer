package org.zuohuang.server.service;

import org.zuohuang.server.pojo.DTO.Project;
import org.zuohuang.server.pojo.DTO.Result;

import java.sql.SQLException;

public interface Projectservice {
    void add(Project project);

    Result Projects();

    Project read(int id);

    void Delete(int id);

    void foto(int id) throws SQLException;

    void update(Project project);
}
