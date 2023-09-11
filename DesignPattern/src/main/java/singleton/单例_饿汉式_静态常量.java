package singleton;

import java.io.Serializable;

public class 单例_饿汉式_静态常量 {
    public static void main(String[] args) {
       Singleton4 instance = Singleton4.getInstance();
       EscapeSingletonUtil.serializeTest(instance);//序列化Test下单例被破坏
       EscapeSingletonUtil.reflectTest(instance);//反射Test下单例模式被破坏
    }

}


//饿汉式(静态变量)

class Singleton4 implements Serializable {

    //1. 构造器私有化, 外部能new
    private Singleton4() {

    }

    //2.本类内部创建对象实例
    private final static Singleton4 instance = new Singleton4();

    //3. 提供一个公有的静态方法，返回实例对象
    public static Singleton4 getInstance() {
        return instance;
    }

}
