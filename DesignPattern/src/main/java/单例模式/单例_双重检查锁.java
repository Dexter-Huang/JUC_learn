package 单例模式;

import java.io.Serializable;

class Singleton3 implements Serializable {
    private static volatile Singleton3 instance;
    private Singleton3() {
        if(instance != null) {
            throw new RuntimeException("对象已经被创建了！"); // 防止反射破坏单例模式
        }
    } // 构造函数私有化
    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) { // 同步锁
                if (instance == null) {
                    instance = new Singleton3();
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
public class 单例_双重检查锁 {
    public static void main(String[] args) {
        EscapeSingletonUtil.serializeTest(Singleton3.getInstance());
        EscapeSingletonUtil.reflectTest(Singleton3.getInstance());
    }
}
