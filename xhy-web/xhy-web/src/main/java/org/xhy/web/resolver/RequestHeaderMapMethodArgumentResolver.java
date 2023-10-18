package org.xhy.web.resolver;

import org.springframework.core.MethodParameter;
import org.xhy.web.annotation.RequestHeader;
import org.xhy.web.convert.ConvertComposite;
import org.xhy.web.handler.HandlerMethod;
import org.xhy.web.support.WebServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 获取所有请求头中的内容
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 14:07
 */
public class RequestHeaderMapMethodArgumentResolver implements HandlerMethodArgumentResolver{
    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        return parameter.hasParameterAnnotation(RequestHeader.class) && parameter.getParameterType() == Map.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, HandlerMethod handlerMethod, WebServletRequest webServletRequest, ConvertComposite convertComposite) throws Exception {

        final HttpServletRequest request = webServletRequest.getRequest();
        final Enumeration<String> headerNames = request.getHeaderNames();
        Map<String,String> resultMap = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            final String key = headerNames.nextElement();
            final String value = request.getHeader(key);
            resultMap.put(key,value);
        }

        return resultMap;
    }
}
