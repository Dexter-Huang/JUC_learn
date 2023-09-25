package 单例模式;

import java.io.Serializable;

class Singleton1 implements Serializable {
    private final static Singleton1 instance = new Singleton1();
    private Singleton1() {
        if(instance != null) {
            throw new RuntimeException("对象已经被创建了！"); // 防止反射破坏单例模式
        }
    } // 构造函数私有化
    public static Singleton1 getInstance() {
        return instance;
    }

    private Object readResolve() { // 防止反序列化破坏单例模式
        // 在JDK反序列化时会判断类是否有readResolve方法，如果有则会调用该方法返回对象，而不是重新创建对象
        return instance;
    }
}

public class 单例_饿汉_静态常量 {
    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();
        EscapeSingletonUtil.serializeTest(instance);
        EscapeSingletonUtil.reflectTest(instance);
    }

}


