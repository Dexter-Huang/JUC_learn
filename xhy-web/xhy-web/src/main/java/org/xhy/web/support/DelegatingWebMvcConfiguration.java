package org.xhy.web.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.xhy.web.intercpetor.InterceptorRegistry;

import java.util.List;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-16 00:07
 */
public class DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport{


    private WebMvcComposite webMvcComposite = new WebMvcComposite();

    @Autowired(required = false)
    public void setWebMvcComposite(List<WebMvcConfigurer> webMvcConfigurers){
        webMvcComposite.addWebMvcConfigurers(webMvcConfigurers);

    }

    @Override
    protected void getIntercept(InterceptorRegistry registry) {
        webMvcComposite.addIntercept(registry);
    }
}
