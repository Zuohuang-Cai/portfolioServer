package org.zuohuang.server.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.zuohuang.server.pojo.DTO.Admin;

import java.util.Date;

@Mapper
@Component
public interface Loginmapper {

    @Select("select * from admins where username=#{username} and password=#{password}")
    Admin login(Admin admin);

    @Insert("insert into Clients(ip,CurrentTime) values(#{ip},#{CurrentTime})")
    void ip(String ip, Date CurrentTime);

}
