package singleton;

public class 单例_静态内部类 {

    public static void main(String[] args) {
        System.out.println("使用静态内部类完成单例模式");
        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());

    }

}

// 静态内部类完成， 推荐使用
class Singleton2 {
    private static volatile Singleton2 instance;

    //构造器私有化
    private Singleton2() {}

    //写一个静态内部类,该类中有一个静态属性 Singleton
    private static class SingletonInstance {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    //提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE

    public static synchronized Singleton2 getInstance() {

        return SingletonInstance.INSTANCE;
    }
}
