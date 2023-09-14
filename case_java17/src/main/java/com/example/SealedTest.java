package com.example;

final class A extends SealedTest {

}

non-sealed class B extends SealedTest {

}
/**  C不能继承SealedTest，因为只permits了A，B  **/
//class C extends SealedTest {
//
//}

public sealed class SealedTest permits A, B { // permits关键字用于声明可以被继承的类

    public static void main(String[] args) {
        SealedTest sealedTest = new A();
        System.out.println(sealedTest instanceof A);
        System.out.println(sealedTest instanceof B);
    }

}

