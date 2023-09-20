package singleton;

import java.io.Serializable;

// 懒汉式(线程安全，同步方法)
class Singleton9 implements Serializable {
    private static volatile Singleton9 instance;
    private Singleton9() {
        if(instance != null) {
            throw new RuntimeException("对象已经创建");
        }
    }
    //提供一个静态的公有方法，加入双重检查代码，解决线程安全问题, 同时解决懒加载问题
//同时保证了效率, 推荐使用
    public static synchronized Singleton9 getInstance() {
        if(instance == null) {
            synchronized (Singleton9.class) {
                if(instance == null) {
                    instance = new Singleton9();
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
public class 单例_懒汉_synchronized代码块 {
    public static void main(String[] args) {
        Singleton9 instance = Singleton9.getInstance();
        EscapeSingletonUtil.serializeTest(Singleton9.getInstance());
        EscapeSingletonUtil.reflectTest(Singleton9.getInstance());
    }
}
