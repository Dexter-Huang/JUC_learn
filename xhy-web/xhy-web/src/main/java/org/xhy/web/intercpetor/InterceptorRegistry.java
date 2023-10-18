package org.xhy.web.intercpetor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-16 00:24
 */
public class InterceptorRegistry {

    private List<InterceptorRegistration> interceptorRegistrations = new ArrayList<>();

    public InterceptorRegistration addInterceptor(HandlerInterceptor interceptor) {
        final InterceptorRegistration interceptorRegistration = new InterceptorRegistration();
        interceptorRegistration.setInterceptor(interceptor);
        interceptorRegistrations.add(interceptorRegistration);
        return interceptorRegistration;
    }


    // 转换成路径映射匹配的拦截器
    public List<MappedInterceptor> getInterceptors() {
        final List<MappedInterceptor> mappedInterceptorList = this.interceptorRegistrations.stream().map(MappedInterceptor::new).collect(Collectors.toList());
        return mappedInterceptorList;
    }
}
