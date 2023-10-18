package org.xhy.web.convert;

import org.springframework.util.ObjectUtils;
import org.xhy.web.excpetion.NotFoundException;
import org.xhy.web.handler.HandlerMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 14:06
 */
public class ConvertComposite {

    private Map<Class,ConvertHandler> convertMap = new HashMap<>();


    public void addConvertMap(Map<Class, ConvertHandler> convertMap) {
        this.convertMap.putAll(convertMap);
    }

    // todo 当前是全局的类型转换器
    public Object convert(HandlerMethod handlerMethod,Class<?> parameterType, Object result) throws Exception{

        // 先执行局部的
        final Map<Class, ConvertHandler> convertHandlerMap = handlerMethod.getConvertHandlerMap();
        if (!ObjectUtils.isEmpty(convertHandlerMap)){
            final ConvertHandler convertHandler = convertHandlerMap.get(parameterType);
            if (convertHandler!=null){
                return convertHandler.convert(result);
            }
        }
        // 全局的
        if (convertMap.containsKey(parameterType)) {
            final ConvertHandler convertHandler = convertMap.get(parameterType);
            try {
                return convertHandler.convert(result);
            } catch (Exception e) {
                // 类型转换异常
                e.printStackTrace();
            }
        }
        // 没找到
        throw new NotFoundException(parameterType.getName() + "没有该参数类型的类型转换器");
    }
}
