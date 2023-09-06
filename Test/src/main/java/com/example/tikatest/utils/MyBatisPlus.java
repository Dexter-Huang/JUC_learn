package com.example.tikatest.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * @author 张峰
 * @create 2022/2/21 20:37
 */
public class MyBatisPlus {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2b8";
        String username="root";
        String password="1234";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir() //禁止打开输出目录
                            .outputDir("D:\\Desktop\\2022_interview\\interview\\mycode\\Test\\src\\main\\java\\com\\example\\tikatest"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.tikatest") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\Desktop\\2022_interview\\interview\\mycode\\Test\\src\\main\\resources\\mapper\\")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok(); //启动lombok
                    builder.mapperBuilder().enableMapperAnnotation().build(); //启用@mapper注释
                    builder.controllerBuilder().enableHyphenStyle().enableRestStyle(); //启用驼峰转连字符样式
                    builder.addInclude("user"); // 设置需要生成的表名
                })
                .execute();
    }
}
