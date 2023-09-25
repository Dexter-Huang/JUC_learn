package 单例模式;

import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Paths;
public class EscapeSingletonUtil {

    public static void reflectTest (Object obj) {
        try {
            // 判断obj是enum的实例
            if(obj instanceof Enum) {

                // 创建enum 实例
                Enum<?> enumObj = (Enum<?>) obj;
                // 获取enum的class对象
                Class<?> clazz = enumObj.getDeclaringClass();
                // 获取enum的构造函数
                Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
                constructor.setAccessible(true);
                // 通过构造函数创建enum实例
                Object obj2 = constructor.newInstance("枚举", 0);

            }
            Constructor<?> constructor = obj.getClass().getDeclaredConstructor();
            constructor.setAccessible(true);
            Object obj2 = constructor.newInstance();
            System.out.println(obj == obj2?"反射Test下单例模式未被破坏":"反射Test下单例模式被破坏");// false
        } catch (Exception e) {
            e.printStackTrace();
        } // try-with-resources 不需要写finally
    }

    public static void serializeTest (Object obj) {
        try(
                ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("tmp.txt")));
                ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("tmp.txt")))
            ) {
            oos.writeObject(obj);
            Object obj2 = ois.readObject();
            System.out.println(obj == obj2?"序列化Test下单例未被破坏":"序列化Test下单例被破坏");// false
        } catch (Exception e) {
            e.printStackTrace();
        } // try-with-resources 不需要写finally
    }

    public static void closeInputStream(InputStream is) {
        if(is != null) {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeOutputStream(OutputStream oos) {
        if(oos != null) {
            try {
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}




