package stringTest;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
//        test.test1();
//        test.test2();
//        test.test3();
//        test.test4();
        test.test5();
    }

    public void test1() {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2); // true
    }

    public void test2() {
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1 == s2); // false
    }

    public void test3() {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = s2.intern();
        System.out.println(s1==s2); // false
        System.out.println(s2==s3); // false
        System.out.println(s1==s3); // true
    }

    public void test4() {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = new String(new char[]{'a','b','c'});
        System.out.println(s1==s2); // false
        System.out.println(s2==s3); // false
        System.out.println(s1==s3); // true
    }

    public void test5() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "c";
        String tmp = s1 + s2 + s3;
        String s4 = "abc";
        System.out.println(s4 == tmp); // false
    }



}
