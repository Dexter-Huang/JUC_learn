package singleton.doubleCheckLock;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EscapeSingleton {

    public static void method1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Singleton instance1 = Singleton.getInstance();
        // 通过反射获取私有构造函数
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        // 设置构造函数为可访问
        constructor.setAccessible(true);
        // 调用构造函数创建第二个实例
        Singleton instance2 = constructor.newInstance();
        System.out.println(instance1 == instance2);// false 说明单例模式被破坏了
    }

    public static void method2() {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);// true
    }

    public static void method3() { // 反序列化破坏单例模式
        try(
                ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("tmp.txt")));
                ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("tmp.txt")));
            ) {
            Singleton instance1 = Singleton.getInstance();
            oos.writeObject(instance1);
            Singleton instance2 = (Singleton) ois.readObject();
            System.out.println(instance1 == instance2);// false
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        method3();
    }
}
