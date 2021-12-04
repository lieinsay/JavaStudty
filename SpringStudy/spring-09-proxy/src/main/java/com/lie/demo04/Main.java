package com.lie.demo04;

import com.lie.demo02.UserService;
import com.lie.demo02.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        // 真实角色
        UserService userService = new UserServiceImpl();
        
        // 代理角色
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        pih.setTarget(userService);
        // 动态生成代理类
        UserService proxy = (UserService) pih.getProxy();


        proxy.delete();
        proxy.add();
        proxy.query();
        proxy.update();
    }
}
