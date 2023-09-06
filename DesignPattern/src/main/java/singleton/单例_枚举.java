package singleton;

public class 单例_枚举 {
    public static void main(String[] args) {
        Singleton1 instance = Singleton1.INSTANCE;
        Singleton1 instance2 = Singleton1.INSTANCE;
        System.out.println(instance == instance2);

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());

        instance.sayOK();
    }
}

//使用枚举，可以实现单例, 推荐
enum Singleton1 {
    INSTANCE; //属性
    public void sayOK() {
        System.out.println("ok~");
    }
}
