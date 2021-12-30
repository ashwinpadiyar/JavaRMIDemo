package my.java.example.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Bank extends Remote {
    List<Customer> getCustomer() throws RemoteException;
}
