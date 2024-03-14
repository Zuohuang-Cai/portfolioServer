package org.zuohuang.server.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.zuohuang.server.pojo.DTO.Log;


@Mapper
@Component

public interface Logmapper {
    @Insert("insert into logs (admin_id, type, info) values (#{admin_id}, #{type}, #{info})")
    void addlogs(Log log);
}
