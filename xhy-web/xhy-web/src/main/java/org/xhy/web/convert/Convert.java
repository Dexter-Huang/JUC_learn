package org.xhy.web.convert;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @Author: Xhy
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @CreateTime: 2023-10-05 21:48
 */
public abstract class Convert<T> {

    protected Class<T> type;

    public Class<T> getType() {
        return type;
    }

    public Convert(Class<T> type){
        this.type = type;
    }

    protected abstract Object convert(Object arg) throws Exception;


    protected Object defaultConvert(String text) throws Exception {
        return type.getConstructor(String.class).newInstance(text);
    }

}
