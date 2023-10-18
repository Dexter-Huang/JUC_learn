package org.xhy.web.convert;

import java.util.Collection;
import java.util.HashSet;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-12 14:14
 */
public class SetConvert extends Convert<HashSet>{

    public SetConvert(Class<HashSet> type) {
        super(type);
    }

    @Override
    protected Object convert(Object arg) throws Exception {
        return this.type.getConstructor(Collection.class).newInstance(arg);
    }
}
