package com.lie.dao;

import com.lie.pojo.User;
import com.lie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getUserByIdTest(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);
            System.out.println(user);
        }
    }

    @Test
    public void testLog4j(){
        logger.info("info:");
        logger.debug("debug");
        logger.error("error");
    }

    @Test
    public void getUserByLimit(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("startIndex",0);
            map.put("pageSize",2);
            List<User> lists = mapper.getUserByLimit(map);
            for (User user : lists) {
                System.out.println(user);
            }
        }
    }
}
