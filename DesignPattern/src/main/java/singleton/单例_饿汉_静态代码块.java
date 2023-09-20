package singleton;

import java.io.Serializable;

class Singleton implements Serializable {
    //1. 构造器私有化, 外部能 new
    private Singleton() {
        if(instance != null) {
            throw new RuntimeException("对象已经被创建了！"); // 防止反射破坏单例模式
        }
    }

    //2.本类内部创建对象实例
    private static Singleton instance;

    static { // 在静态代码块中，创建单例对象
        instance = new Singleton();
    }

    //3. 提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }
    private Object readResolve() { // 防止反序列化破坏单例模式
        // 在JDK反序列化时会判断类是否有readResolve方法，如果有则会调用该方法返回对象，而不是重新创建对象
        return instance;
    }
}

public class 单例_饿汉_静态代码块 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        EscapeSingletonUtil.serializeTest(Singleton.getInstance());
        EscapeSingletonUtil.reflectTest(Singleton.getInstance());
    }
}
