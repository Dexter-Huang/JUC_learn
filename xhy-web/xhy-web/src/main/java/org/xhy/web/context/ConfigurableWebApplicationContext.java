package org.xhy.web.context;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-14 12:38
 */
public interface ConfigurableWebApplicationContext extends WebApplicationContext {

    void setServletContext(ServletContext servletContext);

    void setServletConfig(ServletConfig servletConfig);

    ServletContext getServletContext();

    ServletConfig getServletConfig();
}
