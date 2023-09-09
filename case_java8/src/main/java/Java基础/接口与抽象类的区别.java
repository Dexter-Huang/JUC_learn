package Java基础;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;


interface Interface1 {
    void test();
    int a = 1;
    // 3. 接口中不能有静态代码块，抽象类中可以有
//    static {
//        System.out.println("Interface1 static block");
//    }
    // 4. 接口中不能有构造方法，抽象类中可以有
//    Interface1() {}

}

abstract class Abstract1 {
    abstract void test2();
    void test() {
        System.out.println("Abstract1 test");
    }

    int a = 1;
    static {
        System.out.println("Abstract1 static block");
    }
    Abstract1() {}
}

public class 接口与抽象类的区别 {
    @Test
    public void test(){
        // 1. 接口中的方法默认是public abstract的，抽象类中的方法默认是default的
        // getMethods()方法返回的是public的方法，getDeclaredMethods()方法返回的是所有方法
        System.out.println(Interface1.class.getMethods().length); // 1
        for (Method method : Interface1.class.getMethods()){
            // 修饰符为0，说明是default的
            // 修饰符为1，说明是public的
            // 修饰符为2，说明是private的
            // 修饰符为4，说明是protected的
            // 修饰符为8，说明是static的
            // 修饰符为16，说明是final的
            // 修饰符为32，说明是synchronized的
            // 修饰符为64，说明是volatile的
            // 修饰符为128，说明是transient的
            // 修饰符为256，说明是native的
            // 修饰符为512，说明是interface的
            // 修饰符为1024，说明是abstract的
            System.out.println(method.getName()+" "+method.getModifiers());
        }
        System.out.println("===");
        for(Method method : Interface1.class.getDeclaredMethods()){
            System.out.println(method.getName()+" "+method.getModifiers());
        }
        System.out.println(Abstract1.class.getMethods().length); // 9
        for(Method method : Abstract1.class.getMethods()){
            System.out.println(method.getName()+" "+method.getModifiers());
        }
        System.out.println("===");
        for(Method method : Abstract1.class.getDeclaredMethods()){
            //
            System.out.println(method.getName()+" "+method.getModifiers()); // 2
        }
    }

    @Test
    public void test2(){
        // 2. 接口中的变量默认是public static final的，抽象类中的变量默认是default的
        // getFields()方法返回的是public的字段，getDeclaredFields()方法返回的是所有字段
        System.out.println(Interface1.class.getFields().length); // 1
        System.out.println(Abstract1.class.getFields().length); // 0
    }

    @Test
    public void test3(){
        // 3. 接口中不能有静态代码块，抽象类中可以有
        // getFields()方法返回的是public的字段，getDeclaredFields()方法返回的是所有字段
        System.out.println(Interface1.class.getFields().length); // 1
        System.out.println(Abstract1.class.getFields().length); // 0
    }

    @Test
    public void test4(){
        // 4. 接口中不能有构造方法，抽象类中可以有
        Abstract1 abstract1 = new Abstract1() {
            @Override
            void test2() {
                System.out.println("Abstract1 test2");
            }
        };

        System.out.println(abstract1.getClass().getModifiers()); // 1
        // 获取抽象类所有方法的权限修饰符
        for(Method method : abstract1.getClass().getDeclaredMethods()){
            System.out.println(method.getModifiers()); //
            // 修饰符为0，说明是default的
            // 修饰符为1，说明是public的
        }
        abstract1.test(); // Abstract1 test--
        abstract1.test2(); // Abstract1 test2
    }

    @Test
    public void test5(){

    }
}
