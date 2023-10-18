package org.xhy.web.support;

import org.springframework.context.annotation.Bean;
import org.xhy.web.adapter.HandlerMethodAdapter;
import org.xhy.web.adapter.RequestMappingHandlerMethodAdapter;
import org.xhy.web.handler.HandlerMapping;
import org.xhy.web.handler.RequestMappingHandlerMapping;
import org.xhy.web.intercpetor.HandlerInterceptor;
import org.xhy.web.intercpetor.InterceptorRegistry;
import org.xhy.web.intercpetor.MappedInterceptor;
import org.xhy.web.resolver.DefaultHandlerExceptionResolver;
import org.xhy.web.resolver.ExceptionHandlerExceptionResolver;
import org.xhy.web.resolver.HandlerExceptionResolver;

import java.util.List;

/**
 * @description: 初始化组件
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-16 00:07
 */
public abstract class WebMvcConfigurationSupport {

    // 初始化组件

    @Bean
    public HandlerMapping handlerMapping(){

        final RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.setOrder(0);
        final InterceptorRegistry registry = new InterceptorRegistry();
        getIntercept(registry);
        // todo 通过 registry 获取 MappedInterceptor
        // 获取拦截器
        final List<MappedInterceptor> interceptors = registry.getInterceptors();
        requestMappingHandlerMapping.addHandlerInterceptors(interceptors);
        // 添加拦截器
        return requestMappingHandlerMapping;
    }

    protected abstract void getIntercept(InterceptorRegistry registry);

    @Bean
    public HandlerMethodAdapter handlerMethodAdapter(){
        final RequestMappingHandlerMethodAdapter requestMappingHandlerMethodAdapter = new RequestMappingHandlerMethodAdapter();
        requestMappingHandlerMethodAdapter.setOrder(0);
        return requestMappingHandlerMethodAdapter;
    }

    @Bean
    public HandlerExceptionResolver defaultHandlerExceptionResolver(){

        final DefaultHandlerExceptionResolver defaultHandlerExceptionResolver = new DefaultHandlerExceptionResolver();
        defaultHandlerExceptionResolver.setOrder(1);
        return defaultHandlerExceptionResolver;
    }

    @Bean
    public HandlerExceptionResolver exceptionHandlerExceptionResolver(){

        final ExceptionHandlerExceptionResolver exceptionHandlerExceptionResolver = new ExceptionHandlerExceptionResolver();
        exceptionHandlerExceptionResolver.setOrder(0);
        return exceptionHandlerExceptionResolver;
    }

}

