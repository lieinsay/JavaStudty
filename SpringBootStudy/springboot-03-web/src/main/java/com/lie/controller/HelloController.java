package com.lie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class HelloController {

    @RequestMapping("/test")
    public String hello(Model model){
        return "test";
    }

}
