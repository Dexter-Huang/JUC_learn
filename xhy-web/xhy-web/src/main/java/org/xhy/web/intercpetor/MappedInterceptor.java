package org.xhy.web.intercpetor;

import org.springframework.util.AntPathMatcher;
import org.xhy.web.handler.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-16 00:25
 */
public class MappedInterceptor implements HandlerInterceptor{

    // 拦截器
    private  HandlerInterceptor interceptor;
    // 拦截路径
    private List<String> includePatterns = new ArrayList<>();
    // 排除路径
    private List<String> excludePatterns = new ArrayList<>();

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    // 路径匹配
    public boolean match(String path){
        // 排除了，则不加入
        for (String excludePattern : this.excludePatterns) {
            if (antPathMatcher.match(excludePattern,path)){
                return false;
            }
        }
        // 如果匹配上则加入
        for (String includePattern : this.includePatterns) {
            if (antPathMatcher.match(includePattern,path)){
                return true;
            }
        }
        return false;
    }


    public MappedInterceptor(InterceptorRegistration interceptorRegistration){
        this.interceptor = interceptorRegistration.getInterceptor();
        this.includePatterns = interceptorRegistration.getIncludePatterns();
        this.excludePatterns = interceptorRegistration.getExcludePatterns();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response) {
        return interceptor.preHandle(request,response);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response) {
        interceptor.postHandle(request,response);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler, Exception ex) {
        interceptor.afterCompletion(request,response,handler,ex);
    }
}
