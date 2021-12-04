package com.lie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 如果我们要扩展springMvc，官方建议
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // 视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/lie").setViewName("ttt");
    }
}
