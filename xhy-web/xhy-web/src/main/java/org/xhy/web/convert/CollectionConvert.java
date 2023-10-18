package org.xhy.web.convert;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-12 14:11
 */
public class CollectionConvert extends Convert<Collection>{

    public CollectionConvert(Class<Collection> type) {
        super(type);
    }

    @Override
    protected Object convert(Object arg) throws Exception {

        return ArrayList.class.getConstructor(Collection.class).newInstance(arg);
    }
}
