//package com.example.tikatest;
//
//public class StudentSort2 extends Person2{
//    private static int num = 20;
////    private static StudentSort2 t1 = new StudentSort2();
//    private String school;
//
//    {
//        System.out.println("=====子类初始化块开始=====");
//        school = "大学";
//        System.out.println(school);
//        System.out.println("=====子类初始化块结束=====");
//    }
//
//    static {
//        System.out.println("=====子类静态块开始=====");
//        System.out.println("=====子类静态块结束=====");
//    }
//    public StudentSort2(){
//        System.out.println("=====子类无参构造函数开始=====");
//        System.out.println("=====子类无参构造函数结束=====");
//    }
//
//    public StudentSort2(String name,int age){
//        super(name,age);
//        System.out.println("=====子类有参构造函数开始=====");
//        System.out.println("=====子类有参构造函数结束=====");
//    }
//
//    public static void main(String[] args) {
//        System.out.println("~~~~~~main方法开始~~~~~~");
//        Person2 p1 = new StudentSort2();
////        Person2 p2 = new StudentSort2("张三",40);
//    }
//}
//
//class Person2{
//    private String name;
//    private static Person2 person = new Person2();
//    private static int n = 10;
//    private final int age = setAge();
//
//    {
//        System.out.println("=====父类初始化块开始=====");
//        System.out.println("初始化块");
//        System.out.println("age = "+ age);
//        System.out.println("=====父类初始化块结束=====");
//    }
//
//    static {
//        System.out.println("=====父类静态块开始=====");
//        System.out.println("静态块");
//        System.out.println("n = "+ n);
//        System.out.println("=====父类静态块结束=====");
//    }
//
//    public static int setAge(){
//        System.out.println("=====父类静态方法setAge开始=====");
//        System.out.println("=====父类静态方法setAge结束=====");
//        return n++;
//    }
//
//    public Person2(){
//        System.out.println("====父类无参构造函数开始====");
//        System.out.println("age = "+ age);
//        System.out.println("====父类无参构造函数结束====");
//    }
//    public Person2(String name,int age){
//        System.out.println("====父类有参构造函数开始====");
//        this.name = name;
//        this.age = age;
//        System.out.println("有参构造函数");
//        System.out.println("age = "+age);
//        System.out.println("====父类有参构造函数结束====");
//    }
//}
//
