package org.xhy.web.support;

import org.xhy.web.convert.Convert;
import org.xhy.web.intercpetor.InterceptorRegistry;

/**
 * @description: 定义拓展点规范供子类实现,都是default
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-16 00:07
 */
public interface WebMvcConfigurer {

    default void addIntercept(InterceptorRegistry registry){}
}

