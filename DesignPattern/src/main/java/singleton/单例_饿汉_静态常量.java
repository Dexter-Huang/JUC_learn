package singleton;

import java.io.Serializable;

public class 单例_饿汉_静态常量 {
    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();
        EscapeSingletonUtil.serializeTest(instance);
        EscapeSingletonUtil.reflectTest(instance);
    }

}

class Singleton1 implements Serializable {
    private final static Singleton1 instance = new Singleton1();
    private Singleton1() {} // 构造函数私有化
    public static Singleton1 getInstance() {
        return instance;
    }
}
