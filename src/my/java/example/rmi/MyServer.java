package my.java.example.rmi;

import my.java.example.rmi.BankImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class MyServer {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Remote r = new BankImpl();
        Naming.rebind("rmi://localhost/BankImpl",r);
    }
}
