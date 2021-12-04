package com.lie.dao;

import com.lie.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();
    // 根据id查询用户
    User getUserById(int id);
    // insert一个用户
    boolean addUser(User user);
    // update修改用户
    boolean updateUser(User user);
    // 删除一个用户
    boolean deleteUser(int id);

}
