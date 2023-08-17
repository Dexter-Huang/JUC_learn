package com.springmvc.servlet;

import com.springmvc.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispacherServlet extends HttpServlet {
    private static final long serialVersionUID = -4725740709272967129L;
    private WebApplicationContext webApplicationContext;
    @Override // 初始化读取配置文件
    public void init() throws ServletException {
        // 1.Servlet 初始化时，读取springmmvc.xml的初始化参数,如配置文件路径
        String contextConfigLocation = getServletConfig().getInitParameter("contextConfigLocation").split(":")[1];
        // 2.创建Spring容器
        this.webApplicationContext = new WebApplicationContext(contextConfigLocation);
        // 3.初始化Spring容器
        webApplicationContext.refresh();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
