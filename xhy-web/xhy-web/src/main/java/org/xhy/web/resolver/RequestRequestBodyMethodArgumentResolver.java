package org.xhy.web.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.xhy.web.annotation.RequestBody;
import org.xhy.web.convert.ConvertComposite;
import org.xhy.web.handler.HandlerMethod;
import org.xhy.web.support.WebServletRequest;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * @description: 处理json
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 14:09
 */
public class RequestRequestBodyMethodArgumentResolver implements HandlerMethodArgumentResolver {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestBody.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, HandlerMethod handlerMethod, WebServletRequest webServletRequest, ConvertComposite convertComposite) throws Exception {

        final String json = getJson(webServletRequest.getRequest());
        return objectMapper.readValue(json, parameter.getParameterType());
    }

    public String getJson(HttpServletRequest request){

        final StringBuilder builder = new StringBuilder();
        String line = null;
        try(final BufferedReader reader = request.getReader()) {
            while(line != (line = reader.readLine())){
                builder.append(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return builder.toString();
    }
}
