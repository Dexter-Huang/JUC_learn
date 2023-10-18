package org.xhy.web.context;

import org.springframework.context.ApplicationContext;

/**
 * @description: web ic
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-14 12:37
 */
public interface WebApplicationContext extends ApplicationContext {


    public static final String ROOT_NAME =  WebApplicationContext.class.getName() + "ROOT";
}
