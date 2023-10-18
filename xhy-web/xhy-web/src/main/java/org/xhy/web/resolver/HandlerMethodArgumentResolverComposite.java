package org.xhy.web.resolver;

import org.springframework.core.MethodParameter;
import org.xhy.web.convert.ConvertComposite;
import org.xhy.web.handler.HandlerMethod;
import org.xhy.web.support.WebServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 14:12
 */
public class HandlerMethodArgumentResolverComposite implements HandlerMethodArgumentResolver{

    final List<HandlerMethodArgumentResolver> resolvers = new ArrayList<>();

    Map<MethodParameter,HandlerMethodArgumentResolver> argumentResolverCache = new HashMap<>();

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        for (HandlerMethodArgumentResolver resolver : this.resolvers) {
            if (resolver.supportsParameter(parameter)) {
                argumentResolverCache.put(parameter,resolver);
                return true;
            }
        }
        // 返回false,说明我们没有参数解析器可以应对当前请求携带数据的场景
        return false;
    }

    protected HandlerMethodArgumentResolver getResolverArgument(MethodParameter parameter){
        return argumentResolverCache.get(parameter);
    }

    // 解析参数
    @Override
    public Object resolveArgument(MethodParameter parameter, HandlerMethod handlerMethod, WebServletRequest webServletRequest, ConvertComposite convertComposite) throws Exception {

        // 1.获取对应的参数解析器
        final HandlerMethodArgumentResolver resolverArgument = getResolverArgument(parameter);
        return resolverArgument.resolveArgument(parameter,handlerMethod,webServletRequest,convertComposite);
    }

    public void addResolvers(List<HandlerMethodArgumentResolver> resolvers){
        this.resolvers.addAll(resolvers);
    }
}
