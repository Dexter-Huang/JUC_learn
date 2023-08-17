package com.bruce.controller;

import com.bruce.pojo.User;
import com.bruce.service.UserService;
import com.springmvc.annotation.AutoWired;
import com.springmvc.annotation.Controller;
import com.springmvc.annotation.RequestMapping;
import com.springmvc.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@Controller
public class UserController {
    @AutoWired
    UserService userService;

    @RequestMapping("/findUsers")
    public void findUsers(HttpServletRequest request, HttpServletResponse response,@RequestParam("name")String name) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        List<User> list = userService.findUsers(name);
        PrintWriter out= response.getWriter();
        out.println("<h1>SpringMvc控制器:"+name+"</h1>");
    }
}
