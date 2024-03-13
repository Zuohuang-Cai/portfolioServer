package org.zuohuang.server.mapper;

import org.apache.ibatis.annotations.*;
import org.zuohuang.server.pojo.DTO.Project;
import java.util.List;

@Mapper
public interface Projectmapper {
    @Insert("insert into projects(title,description,Foto,Url) values(#{Title},#{Description},#{Foto},#{Url})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(Project project);

    @Insert("insert into projectTags(ProjectId, Tag) values(#{id},#{Tag})")
    void addTags(Project project);

    @Select("select * from projects inner join projectTags on projects.id=projectTags.ProjectId")
    List<Project> Projects();

}
