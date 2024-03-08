package org.zuohuang.server.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.zuohuang.server.pojo.Admin;

@Mapper
@Component
public interface Loginmapper {

    @Select("select * from admins where username=#{username} and password=#{password}")
    Admin login(Admin admin);
}
