package com.example;

import java.util.Objects;

class Student{
    String name;
    String room;
    public Student(String name, String room){
        this.name = name;
        this.room = room;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if((obj instanceof Student student)){ // 相当于obj != null && getClass() == obj.getClass()
            return name.equals(student.name) && room.equals(student.room);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room);
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj instanceof ListNode node){
            return node.val == this.val&&Objects.equals(node.next,this.next);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(val,next);
        /**
         *        HashCode 底层实现
         *        public static int hashCode(Object a[]) {
         *             if (a == null)
         *                 return 0;
         *
         *             int result = 1;
         *
         *             for (Object element : a)
         *                 result = 31 * result + (element == null ? 0 : element.hashCode());
         *
         *             return result;
         *         }
         */
    }
}
public class EqualHashCodeTest {
    public static void main(String[] args) {
        System.out.println("https://www.yuque.com/huang-odmst/flixs4/oh8og2rpg5ob3l70");
        var s1 = new Student("张三", "101");
        var s2 = new Student("张三", "101");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(null));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println("//------------------------");
        var n1 = new ListNode(1);
        var n2 = new ListNode(1);
        System.out.println(n1.equals(n2));
        System.out.println(n1.hashCode());
        System.out.println(n2.hashCode());
        System.out.println("//-------如果不重写HashCode方法:n3.equals(n4)为true-------");
        var n3 = new ListNode(1);
        var n4 = new ListNode(1);
        var n5 = new ListNode(2);
        var n6 = new ListNode(2);
        var n7 = new ListNode(3);
        n6.next = n7;
        n5.next = null;
        n3.next = n5;
        n4.next = n6;
        System.out.println(n3.equals(n4));
        System.out.println(n3.next.hashCode());
        System.out.println(n4.next.hashCode());

    }
}
