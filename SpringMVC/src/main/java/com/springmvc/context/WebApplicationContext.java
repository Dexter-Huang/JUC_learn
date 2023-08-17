package com.springmvc.context;

import com.springmvc.xml.XmlParser;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebApplicationContext {
    // classpath:springmvc.xml
    private String contextConfigLocation;
    private List<String> classNameList = new ArrayList<String>();


    public WebApplicationContext(String contextConfigLocation) {
        this.contextConfigLocation = contextConfigLocation;
    }

    /**
     * 初始化Spring容器
     */
    public void refresh() {
        // 1. 解析SpringMvc.xml 配置文件 (利用dom4j)
        String basePackage = XmlParser.getBasePackage(contextConfigLocation).split(":")[1];
        String[] basePackages = basePackage.split(",");
        System.out.println("opop:"+basePackages.length);

        // 2. 扫描相关的类
        if(basePackages.length > 0) {
            for(String basePkg : basePackages) {
                // com.bruce.service

                // com.bruce.controller
                executeScanPackage(basePkg);
            }
        }
        System.out.println("扫描包:"+classNameList);
    }

    /**
     * 扫描包,得到包下对应的类
     */
    public void executeScanPackage(String basePackage){
        System.out.println("basePackage:"+basePackage);
        URL url = this.getClass().getClassLoader().getResource("/" + basePackage.replaceAll("\\.", "/"));
        System.out.println("opop");

        String path = url.getFile();// /com/bruce/service
        File file = new File(path);
        for(File f: file.listFiles()){
            if(f.isDirectory()){// 目录
                executeScanPackage(basePackage + "." + f.getName());
            }else{ // 文件 com.bruce.service.UserServiceImpl.class
                classNameList.add(basePackage + "." + f.getName().replace(".class", ""));
            }
        }
    }
}
