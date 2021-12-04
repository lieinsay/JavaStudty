package com.lie;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 登录成功之后，获取用户session
        Object username = request.getSession().getAttribute("loginUsername");
        if(username==null){
            request.setAttribute("msg","没有权限请先登录");
            request.getRequestDispatcher("index").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}
