package org.xhy.web.convert;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-12 14:14
 */
public class ListConvert extends Convert<ArrayList>{

    public ListConvert(Class<ArrayList> type) {
        super(type);
    }

    @Override
    protected Object convert(Object arg) throws Exception {
        return this.type.getConstructor(Collection.class).newInstance(arg);

    }
}
