package org.xhy.web.resolver;

import org.springframework.core.MethodParameter;
import org.xhy.web.annotation.RequestBody;
import org.xhy.web.convert.ConvertComposite;
import org.xhy.web.handler.HandlerMethod;
import org.xhy.web.multipart.MultipartFile;
import org.xhy.web.support.WebServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 获取所有普通数据
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 14:08
 */
public class RequestParamMapMethodArgumentResolver implements HandlerMethodArgumentResolver {



    // 写RequestParam 不写都可以, 会遇到其他的也有不写的场景，HttpServletRequest Mule...
    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        final Class<?> parameterType = parameter.getParameterType();
        if (parameterType == HttpServletResponse.class || parameterType == HttpServletRequest.class){
            return false;
        }
        if (isMultipartFile(parameter)){
            return false;
        }
        if (parameter.hasParameterAnnotation(RequestBody.class)){
            return false;
        }

        return parameterType == Map.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, HandlerMethod handlerMethod, WebServletRequest webServletRequest, ConvertComposite convertComposite) throws Exception {

        Map<String,Object> resultMap = new HashMap<>();

        final HttpServletRequest request = webServletRequest.getRequest();
        final Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k,v)->{
            resultMap.put(k,v[0]);
        });
        return resultMap;
    }



    public static boolean isMultipartFile(MethodParameter parameter){

        final Class<?> parameterType = parameter.getParameterType();
        if (parameterType == MultipartFile.class){
            return true;
        }

        if (parameterType == List.class || parameterType == Collection.class){
            // 获取集合中的泛型是否是MultipartFile []
            final Type genericParameterType = parameter.getGenericParameterType();
            ParameterizedType type = (ParameterizedType)genericParameterType;

            if (type.getActualTypeArguments()[0] == MultipartFile.class) {
                return true;
            }
        }
        if (parameterType.isArray() && parameterType == MultipartFile.class){
            return true;
        }

        return false;
    }
}
