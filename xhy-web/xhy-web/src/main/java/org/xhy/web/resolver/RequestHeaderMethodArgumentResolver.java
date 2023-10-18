package org.xhy.web.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.util.ObjectUtils;
import org.xhy.web.annotation.RequestHeader;
import org.xhy.web.convert.ConvertComposite;
import org.xhy.web.excpetion.NotFoundException;
import org.xhy.web.handler.HandlerMethod;
import org.xhy.web.support.WebServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description: 获取请求头中的指定内容
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 14:07
 */
public class RequestHeaderMethodArgumentResolver implements HandlerMethodArgumentResolver{
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestHeader.class) && parameter.getParameterType() != Map.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, HandlerMethod handlerMethod, WebServletRequest webServletRequest, ConvertComposite convertComposite) throws Exception {

        String name = "";
        final RequestHeader parameterAnnotation = parameter.getParameterAnnotation(RequestHeader.class);
        name = parameterAnnotation.value().equals("") ? parameter.getParameterName() : parameterAnnotation.value();

        final HttpServletRequest request = webServletRequest.getRequest();
        if (parameterAnnotation.require() && ObjectUtils.isEmpty(request.getHeader(name))){
            throw new NotFoundException(handlerMethod.getPath() + "请求头没有携带: " + name);
        }
        return convertComposite.convert(handlerMethod,parameter.getParameterType(),request.getHeader(name));

    }
}
