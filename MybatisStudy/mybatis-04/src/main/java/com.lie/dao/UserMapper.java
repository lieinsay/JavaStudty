package com.lie.dao;

import com.lie.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.Alias;

import java.util.List;
import java.util.Map;

@Alias("User")
public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id")int id);
}
