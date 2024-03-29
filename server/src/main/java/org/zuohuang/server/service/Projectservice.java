package org.zuohuang.server.service;

import org.springframework.web.multipart.MultipartFile;
import org.zuohuang.server.pojo.DTO.Log;
import org.zuohuang.server.pojo.DTO.Project;
import org.zuohuang.server.pojo.DTO.Result;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.SQLException;

public interface Projectservice {
    void add(Project project) throws IOException;

    Result Projects();

    Project read(Project project);

    void Delete(Project project);

    byte[] foto(Project project) throws SQLException, IOException;

    void update(Project project);
}
