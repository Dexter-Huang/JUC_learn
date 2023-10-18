package org.xhy.web.resolver;

import org.springframework.core.MethodParameter;
import org.xhy.web.convert.ConvertComposite;
import org.xhy.web.handler.HandlerMethod;
import org.xhy.web.support.WebServletRequest;

/**
 * @description: 参数解析器顶层接口
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-15 14:05
 */
public interface HandlerMethodArgumentResolver {

    // 当前参数是否支持当前的请求中携带的数据
    boolean supportsParameter(MethodParameter parameter);

    // 解析参数
    Object resolveArgument(MethodParameter parameter, HandlerMethod handlerMethod, WebServletRequest webServletRequest, ConvertComposite convertComposite) throws Exception;
}
