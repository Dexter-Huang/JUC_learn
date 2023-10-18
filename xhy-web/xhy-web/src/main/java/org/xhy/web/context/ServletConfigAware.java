package org.xhy.web.context;

import org.springframework.beans.factory.Aware;

import javax.servlet.ServletConfig;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-14 12:42
 */
public interface ServletConfigAware extends Aware {

    void setServletConfig(ServletConfig servletConfig);
}
