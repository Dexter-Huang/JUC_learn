package com.example.tikatest;
public class SingleSort {
    public static int k = 0;
    public static SingleSort t1 = new SingleSort("t1");
    public static SingleSort t2 = new SingleSort("t2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");

    {
        print("构造块");
    }

    static{
        print("静态块");
    }

    public SingleSort(String str){
        System.out.print("Test1: ");
        System.out.println((++k)+":"+str+"    i="+i+"    n="+n);
        ++i;
        ++n;
    }

    public static int print(String str){
        System.out.print("print: ");
        System.out.println((++k)+":"+str+"    i="+i+"    n="+n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {
        SingleSort singleSort = new SingleSort("init");
    }
}
