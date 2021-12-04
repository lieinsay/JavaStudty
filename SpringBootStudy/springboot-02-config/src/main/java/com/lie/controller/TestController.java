package com.lie.controller;

import com.lie.pojo.Dog;
import com.lie.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class TestController {

    @Autowired
    private Person person;

    @Autowired
    private Dog dog;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return person.toString()+" "+dog.toString();
    }
}
