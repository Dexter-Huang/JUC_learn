package com.example.tikatest;

public class StudentSort extends Person{
    private static int num = 20;
    private String school;

    {
        System.out.println("student初始化块");
        school = "大学";
        System.out.println(school);
    }

    static {
        System.out.println("student静态块");
    }
    public StudentSort(){

    }

    public StudentSort(String name,int age){
        super(name,age);
    }

    public static void main(String[] args) {
        Person p1 = new StudentSort();
        Person p2 = new StudentSort("张三",40);
    }
}

class Person{
    private String name;
    private static Person person = new Person();
    private static int n = 10;
    private int age = setAge();

    {
        System.out.println("初始化块");
        System.out.println("age = "+ age);
    }

    static {
        System.out.println("静态块");
        System.out.println("n = "+ n);
    }

    public static int setAge(){
        return n++;
    }

    public Person(){
        System.out.println("默认构造函数");
        System.out.println("age = "+ age);
    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
        System.out.println("有参构造函数");
        System.out.println("age = "+age);
    }
}

