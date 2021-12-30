package my.java.example.rmi.client;

import my.java.example.rmi.Bank;
import my.java.example.rmi.Customer;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.List;

public class MyClient {
    public static void main(String args[]) throws Exception {
        System.setSecurityManager(new RMISecurityManager());
        Bank b = (Bank) Naming.lookup("rmi://localhost/BankImpl");

        List<Customer> list = b.getCustomer();
        for (Customer c : list) {
            System.out.println(c.getAcc_no() + " " + c.getFirstname() + " " + c.getLastname()
                    + " " + c.getEmail() + " " + c.getAmount());
        }

    }
}
