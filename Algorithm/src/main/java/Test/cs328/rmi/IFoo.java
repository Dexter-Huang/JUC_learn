package Test.cs328.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFoo extends Remote {

    String getMessage() throws RemoteException;

}