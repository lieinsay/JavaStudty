package com.lie.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;


public class People {
    /*
    * <dependency>
         <groupId>jakarta.annotation</groupId>
         <artifactId>jakarta.annotation-api</artifactId>
         <version>1.3.5</version>
      </dependency>
    * Resource 在jdk8之后被抛弃了
    * */
    @Resource(name="cat")
    private Cat cat;
    @Autowired
    @Qualifier(value = "dog")
    private Dog dog;
    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
