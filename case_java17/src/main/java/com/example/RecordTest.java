package com.example;

/**
 * record 本质上是一个类，只是编译器会自动帮我们生成一些方法，比如equals，hashCode，toString等
 */
record User(String name, int age) {
    // 自定义Equals方法
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof User user) {
            return name.equals(user.name) && age == user.age;
        }
        return false;
    }
}

public class RecordTest {
    public static void main(String[] args) {
        User user1 = new User("张三", 18);
        User user2 = new User("张三", 18);
        System.out.println(user1.equals(user2));
    }
}

