package org.xhy.web.convert;

import org.springframework.util.ObjectUtils;
import org.xhy.web.handler.HandlerMethod;

import java.lang.reflect.Method;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 16:46
 */
public class ConvertHandler extends HandlerMethod {

    public ConvertHandler(Object bean, Method method) {
        super(bean,method);
    }

    public Object convert(Object arg) throws Exception {
        if (ObjectUtils.isEmpty(arg)){
            return null;
        }
        return this.getMethod().invoke(this.getBean(),arg);
    }

}
