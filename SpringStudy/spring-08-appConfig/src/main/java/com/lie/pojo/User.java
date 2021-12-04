package com.lie.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")// singleton prototype request session
public class User {

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
