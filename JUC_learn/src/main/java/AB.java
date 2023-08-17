//基于JDK1.8
//IA.java
interface IA {
    int a = 100;
    double NUM = 1;//等价于public static final double NUM = 1;
    String name = "IA";

    void say();
    default void print() {
        System.out.println("IA:print()");
    }
    default void pritA() {
        System.out.println("IA: " + name);
    }
}

//IB.java
interface IB {
    int b = 200;
    double NUM = 2;
    String name = "IB";

    void say();
    default void print() {
        System.out.println("IB:print()");
    }
    default void pritB() {
        System.out.println("IB: " + name);
    }
}

//AB.java
public class AB implements IA, IB {
    public static void main(String[] args) {
        AB ab = new AB();
        //ab.name 报错，不能确定是IA中的name还是IB中的
        System.out.println(a);//100  因为a和b本质上是静态成员，在静态方法里面可以直接访问
        System.out.println(b);//200
        System.out.println(IA.NUM);//1.0
        System.out.println(IB.NUM);//2.0
        System.out.println(IA.name);//IA
        System.out.println(IB.name);//IB
        ab.say();//AB:say()
        ab.print();//AB:print()
        ab.pritA();//IA: IA
        ab.pritB();//IB: IB
    }

    //必须实现接口中未实现的方法，并且根据排序规则，实现的是IA中的say()
    @Override
    public void say() {
        System.out.println("AB:say()");
    }

    //必须重写IA和IB中重复(签名相同)的default方法，否则调用print时不知道调用IA中的实现，还是IB中的。
    @Override
    public void print() {
        System.out.println("AB:print()");
    }
}
