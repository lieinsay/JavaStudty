package com.lie.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component 等价于 <bean id="user" class="com.lie.pojo.User"/>
@Component
@Scope("prototype")// prototype request session
public class User {
    // @Value("Lie") 等价于 <property name="name" value="Lie"/>

    private String name;

    public User() {
        System.out.println("无参构造");
    }

    public User(String name) {
        System.out.println("有参构造");
        this.name = name;
    }

    public String getName() {
        System.out.println("我是User的get");
        return name;
    }

    @Value("Lie")
    public void setName(String name) {
        System.out.println("我是User的set");
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
