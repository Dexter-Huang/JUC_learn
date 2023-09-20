package singleton;

import java.io.Serializable;

// 懒汉式(线程安全，同步方法)
class Singleton5 implements Serializable {
    private static Singleton5 instance;
    private Singleton5() {
        if(instance != null) {
            throw new RuntimeException("对象已经创建");
        }
    }
    //提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
    public static synchronized Singleton5 getInstance() {
        if(instance == null) {
            instance = new Singleton5();
        }
        return instance;
    }
    private Object readResolve() { // 防止反序列化破坏单例模式
        // 在JDK反序列化时会判断类是否有readResolve方法，如果有则会调用该方法返回对象，而不是重新创建对象
        return instance;
    }

}
public class 单例_懒汉_synchronized方法 {
    public static void main(String[] args) {
        Singleton5 instance = Singleton5.getInstance();
        EscapeSingletonUtil.serializeTest(instance);
        EscapeSingletonUtil.reflectTest(instance);
    }
}
