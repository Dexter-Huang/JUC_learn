package org.xhy.web.handler;

import org.springframework.core.Ordered;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 获取映射器
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-14 17:45
 */
public interface HandlerMapping extends Ordered {

    HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception;
}
