package org.xhy.web.resolver;

import org.xhy.web.support.WebServletRequest;

import java.lang.reflect.Method;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 17:12
 */
public interface HandlerMethodReturnValueHandler {


    // 当前method 是否支持
    boolean supportsReturnType(Method method);

    // 执行
    void handleReturnValue(Object returnValue, WebServletRequest webServletRequest) throws Exception;
}
