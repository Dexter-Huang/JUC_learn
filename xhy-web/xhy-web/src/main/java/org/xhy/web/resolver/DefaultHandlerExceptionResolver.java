package org.xhy.web.resolver;

import org.xhy.web.excpetion.ConvertCastException;
import org.xhy.web.excpetion.HttpRequestMethodNotSupport;
import org.xhy.web.excpetion.NotFoundException;
import org.xhy.web.handler.HandlerMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 默认异常解析器，尽可能的枚举所有上层发生的异常进行处理
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 18:06
 */
public class DefaultHandlerExceptionResolver implements HandlerExceptionResolver {

    private int order;

    @Override
    public Boolean resolveException(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler, Exception ex) throws IOException {

        final Class<? extends Exception> type = ex.getClass();
        if (type == ConvertCastException.class) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,ex.getMessage());
            return true;
        }else if (type == HttpRequestMethodNotSupport.class){
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED,ex.getMessage());
            return true;
        }else if (type == NotFoundException.class){
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,ex.getMessage());
            return true;
        }
        return false;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
