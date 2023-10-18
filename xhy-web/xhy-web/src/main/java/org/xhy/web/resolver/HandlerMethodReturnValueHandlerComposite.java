package org.xhy.web.resolver;

import org.xhy.web.excpetion.NotFoundException;
import org.xhy.web.support.WebServletRequest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 17:16
 */
public class HandlerMethodReturnValueHandlerComposite {

    private List<HandlerMethodReturnValueHandler> methodReturnValueHandlers = new ArrayList<>();


    public void addMethodReturnValueHandlers(List<HandlerMethodReturnValueHandler> methodReturnValueHandlers) {
        this.methodReturnValueHandlers.addAll(methodReturnValueHandlers);
    }

    public HandlerMethodReturnValueHandler selectHandler(Method method) throws Exception{
        for (HandlerMethodReturnValueHandler returnValueHandler : this.methodReturnValueHandlers) {
            if (returnValueHandler.supportsReturnType(method)) {
                return returnValueHandler;
            }
        }
        throw new NotFoundException(method.toString() + "找不到返回值处理器");
    }

    public void doInvoke(Object returnValue, Method method, WebServletRequest webServletRequest) throws Exception{
        // 选择返回值处理器
        final HandlerMethodReturnValueHandler returnValueHandler = selectHandler(method);
        // 执行
        returnValueHandler.handleReturnValue(returnValue,webServletRequest);
    }
}
