package org.xhy.web.support;

import org.xhy.web.intercpetor.InterceptorRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-16 00:08
 */
public class WebMvcComposite implements WebMvcConfigurer {

    private List<WebMvcConfigurer> webMvcConfigurers = new ArrayList<>();

    public void addWebMvcConfigurers(List<WebMvcConfigurer> webMvcConfigurers) {
        this.webMvcConfigurers.addAll(webMvcConfigurers);
    }


    @Override
    public void addIntercept(InterceptorRegistry registry) {
        for (WebMvcConfigurer webMvcConfigurer : webMvcConfigurers) {
            webMvcConfigurer.addIntercept(registry);
        }
    }
}


