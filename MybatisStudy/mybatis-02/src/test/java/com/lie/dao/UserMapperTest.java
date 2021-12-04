package com.lie.dao;

import com.lie.pojo.User;
import com.lie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

    @Test
    public void getUserListTest() throws IOException {
        // 建议，自动调取对象的close()方法
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }
//
//    @Test
//    public void getUserByIdTest(){
//        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
//            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//            User user = mapper.getUserById(1);
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void addUserTest(){
//        User useradd = new User("哈哈哈","123123123");
//        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
//            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//            mapper.addUser(useradd);
//            System.out.println(mapper.getUserById(1));
//            // 提交事务
////            sqlSession.commit();
//        }
//    }
//
//    @Test
//    public void updateUserTest(){
//        User userupdate = new User(6,"aswer","asdfasdfasfd");
//        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
//            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//            mapper.updateUser(userupdate);
//            System.out.println(mapper.getUserById(6));
//            // 提交事务
////            sqlSession.commit();
//        }
//    }
//
//    @Test
//    public void deleteUserTest(){
//        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
//            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//            if(mapper.deleteUser(6)){
//                System.out.println("删除成功");
//            }
//            // 提交事务
////            sqlSession.commit();
//        }
//    }

}
