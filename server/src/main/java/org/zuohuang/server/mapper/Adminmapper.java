package org.zuohuang.server.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.zuohuang.server.pojo.DTO.Admin;

@Component
@Mapper
public interface Adminmapper {
    @Insert("insert into admins(username,password) values(#{username},#{password})")
    public void create(Admin admin);

    @Update("update admins set LastLoginTime=#{LastLoginTime} where username=#{username}")
    public void updateLastLoginTime(Admin admin);
}
