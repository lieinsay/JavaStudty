package com.lie.demo04;

import com.lie.demo02.UserService;
import com.lie.demo03.Rent;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

// 使用这个类，自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    // 处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理的本质，反射
        Method[] methods = UserService.class.getDeclaredMethods();
        if(ArrayUtils.contains(methods,method))
            log(method.getName());
        Object result = method.invoke(target, args);
        return null;
    }

    public void log(String msg){
        System.out.println("执行了"+msg+"方法");
    }

}
