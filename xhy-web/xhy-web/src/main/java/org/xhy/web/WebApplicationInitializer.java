package org.xhy.web;

import javax.servlet.ServletContext;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-14 15:17
 */
public interface WebApplicationInitializer {

    void onStartUp(ServletContext servletContext);
}
