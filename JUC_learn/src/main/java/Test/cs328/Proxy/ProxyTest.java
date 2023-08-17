package Test.cs328.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IHelloWorld {
    public void hello();
}

class HelloInvokeHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // object的公用方法直接调用当前invoke对象的。
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
            // 针对接口的不同方法书写我们具体的实现
        } else if ("hello".equals(method.getName())) {
            System.out.println("hello world");
        }
        return null;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        Object object = Proxy.newProxyInstance(
                            IHelloWorld.class.getClassLoader(),
                            new Class[]{IHelloWorld.class},
                            new HelloInvokeHandler()
                        );
        IHelloWorld iHelloWorld = (IHelloWorld) object;
        iHelloWorld.hello();
        System.out.println(iHelloWorld);
        System.out.println(iHelloWorld.getClass());
    }
}
