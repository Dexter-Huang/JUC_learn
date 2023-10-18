package org.xhy.web.intercpetor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 封装拦截器信息
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-16 00:24
 */
public class InterceptorRegistration {


    // 拦截器
    private  HandlerInterceptor interceptor;
    // 拦截路径
    private List<String> includePatterns = new ArrayList<>();
    // 排除路径
    private List<String> excludePatterns = new ArrayList<>();

    public HandlerInterceptor getInterceptor() {
        return interceptor;
    }

    public List<String> getExcludePatterns() {
        return excludePatterns;
    }

    public List<String> getIncludePatterns() {
        return includePatterns;
    }

    public InterceptorRegistration addExcludePatterns(String... path) {

        this.excludePatterns.addAll(Arrays.asList(path));
        return this;
    }


    public InterceptorRegistration addIncludePatterns(String... path) {
        this.includePatterns.addAll(Arrays.asList(path));
        return this;
    }

    public InterceptorRegistration setInterceptor(HandlerInterceptor interceptor) {
        this.interceptor = interceptor;
        return this;
    }

}
