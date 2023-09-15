package Test.cs328.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) throws Exception{

        Registry r = LocateRegistry.getRegistry("localhost", 2000);

        IFoo foo = (IFoo) r.lookup("remoteFoo");
        IFoo foo2 = (IFoo) r.lookup("remoteFoo2");
        System.out.println(foo.getMessage());
        System.out.println(foo2.getMessage());
    }

}
