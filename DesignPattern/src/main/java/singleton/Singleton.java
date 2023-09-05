package singleton;

import java.io.Serializable;

/**
 * DCL(Double Check Lock) 双重检查锁
 */
public class Singleton implements Serializable {
    private static volatile Singleton instance;
    private Singleton() {
        if(instance != null) throw new RuntimeException("对象已经被创建了！"); // 防止反射破坏单例模式
    } // 构造函数私有化
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) { // 同步锁
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    private Object readResolve() { // 防止反序列化破坏单例模式
        // 在JDK反序列化时会判断类是否有readResolve方法，如果有则会调用该方法返回对象，而不是重新创建对象
        return instance;
    }
}
