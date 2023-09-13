package singleton;

import java.io.Serializable;

public class 单例_静态内部类 {

    public static void main(String[] args) {

        Singleton2 instance = Singleton2.getInstance();
        EscapeSingletonUtil.serializeTest(instance);
        EscapeSingletonUtil.reflectTest(instance);

    }

}

// 静态内部类完成， 推荐使用
class Singleton2 implements Serializable {
    private static volatile Singleton2 instance;

    //构造器私有化
    private Singleton2() {}

    //写一个静态内部类,该类中有一个静态属性 Singleton
    private static class SingletonInstance {
        private static final Singleton2 INSTANCE = new Singleton2();
        private Object readResolve() { // 防止反序列化破坏单例模式
            // 在JDK反序列化时会判断类是否有readResolve方法，如果有则会调用该方法返回对象，而不是重新创建对象
            return instance;
        }

    }

    //提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE

    public static synchronized Singleton2 getInstance() {

        return SingletonInstance.INSTANCE;
    }
}
