package org.xhy.web.handler;

import java.lang.reflect.Method;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 18:37
 */
public class ExceptionHandlerMethod extends HandlerMethod{
    public ExceptionHandlerMethod(Object bean, Method method) {
        super(bean, method);
    }
}
