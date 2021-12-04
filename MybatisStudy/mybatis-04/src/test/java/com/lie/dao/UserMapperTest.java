package com.lie.dao;

import com.lie.pojo.LomboxTest;
import com.lie.pojo.User;
import com.lie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void getUsers(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.getUsers();

            for (User user : users) {
                System.out.println(user);
            }
            User user = mapper.getUserById(1);
            System.out.println(user);
//            sqlSession.commit();
        }
    }

    @Test
    public void lomboxTest(){
        LomboxTest test = new LomboxTest();
        System.out.println(test);

    }
}
