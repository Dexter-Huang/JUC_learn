package Test.cs328.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.createRegistry(2000);
            IFoo foo = new Foo();
            IFoo foo2 = new Foo2();
            registry.bind("remoteFoo", foo);
            registry.bind("remoteFoo2", foo2);
            System.out.println("RMI registry started.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

