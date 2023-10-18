package org.xhy.web.resolver;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.xhy.web.annotation.ResponseBody;
import org.xhy.web.support.WebServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 17:13
 */
public class RequestResponseBodyMethodReturnValueHandler implements HandlerMethodReturnValueHandler{

    // 避免对应实体类没有get方法
    final ObjectMapper objectMapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    @Override
    public boolean supportsReturnType(Method method) {
        return AnnotatedElementUtils.hasAnnotation(method.getDeclaringClass(), ResponseBody.class) || AnnotatedElementUtils.hasAnnotation(method,ResponseBody.class);
    }

    @Override
    public void handleReturnValue(Object returnValue, WebServletRequest webServletRequest) throws Exception {

        final HttpServletResponse response = webServletRequest.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(objectMapper.writeValueAsString(returnValue));
        response.getWriter().flush();


    }
}
