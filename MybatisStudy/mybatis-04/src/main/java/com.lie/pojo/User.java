package com.lie.pojo;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {
    private int id;
    private String name;
    private String password;

    public User() {
    }

    public User(String name, String pwd) {
        this.name = name;
        this.password = pwd;
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.password = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pwd) {
        System.out.println("我被调用了");
        this.password = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + password + '\'' +
                '}';
    }
}
