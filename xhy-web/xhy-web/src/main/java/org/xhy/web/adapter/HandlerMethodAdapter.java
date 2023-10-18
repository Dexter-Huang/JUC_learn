package org.xhy.web.adapter;

import org.springframework.core.Ordered;
import org.xhy.web.handler.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 适配器接口
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 13:03
 */
public interface HandlerMethodAdapter extends Ordered {

    boolean support(HandlerMethod handlerMethod);

    void handler(HttpServletRequest req, HttpServletResponse res, HandlerMethod handler) throws Exception;


}
