package com.lie.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 使用这个类，自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                rent.getClass().getInterfaces(),
                this);
    }

    // 处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理的本质，反射
        seeHouse();
        Object result = method.invoke(rent, args);
        return null;
    }

    public void seeHouse(){
        System.out.println("zhongjiedaikanfangzhi");
    }
}
