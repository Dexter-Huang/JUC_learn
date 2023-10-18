package org.xhy.web.resolver;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.springframework.core.MethodParameter;
import org.xhy.web.annotation.Cookie;
import org.xhy.web.convert.ConvertComposite;
import org.xhy.web.excpetion.NotFoundException;
import org.xhy.web.handler.HandlerMethod;
import org.xhy.web.support.WebServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 解析cookie当中的参数
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 14:07
 */
public class RequestCookieMethodArgumentResolver implements HandlerMethodArgumentResolver{
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Cookie.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, HandlerMethod handlerMethod, WebServletRequest webServletRequest, ConvertComposite convertComposite) throws Exception {

        final Cookie parameterAnnotation = parameter.getParameterAnnotation(Cookie.class);
        String name = "";
        name = parameterAnnotation.value().equals("") ? parameter.getParameterName() :parameterAnnotation.value();
        final HttpServletRequest request = webServletRequest.getRequest();
        // 获取所有cookie
        final javax.servlet.http.Cookie[] cookies = request.getCookies();
        // 遍历拿值
        for (javax.servlet.http.Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return convertComposite.convert(handlerMethod,parameter.getParameterType(),cookie.getValue());
            }
        }

        if (parameterAnnotation.require()){
            throw new NotFoundException(handlerMethod.getPath() +"cookie没有携带: "+ name);

        }

        return null;
    }
}
