package org.zuohuang.server.mapper;

import org.apache.ibatis.annotations.*;
import org.zuohuang.server.pojo.DTO.Project;
import org.zuohuang.server.pojo.DTO.Result;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Mapper
public interface Projectmapper {
    @Insert("insert into projects(title,description,Foto,Url) values(#{Title},#{Description},#{Foto},#{Url})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(Project project);

    @Insert("insert into projectTags(ProjectId, Tag) values(#{id},#{Tag})")
    void addTags(Project project);

    @Select("select title, description, CreateTime, Url, ProjectId, Tag from projects inner join projectTags on projects.id=projectTags.ProjectId")
    List<Project> Projects();

    @Select("select title, description, CreateTime,Url, ProjectId, Tag from projects  inner join projectTags on projects.id=projectTags.ProjectId where projects.id=#{id}")
    Project read(int id);

    @Delete("delete from projects where id=#{id}")
    void deleteProject(int id);

    @Delete("delete from projectTags where ProjectId=#{id}")
    void deleteTags(int id);

    @Select("select Foto from projects where id=#{id}")
    List<Byte> foto(int id) throws SQLException;
}