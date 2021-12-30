package my.java.example.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankImpl extends UnicastRemoteObject implements Bank {
    public BankImpl() throws RemoteException {
    }

    @Override
    public List<Customer> getCustomer() throws RemoteException {
        List<Customer> list = new ArrayList<Customer>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmi", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from customer");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customer c = new Customer();
                c.setAcc_no(rs.getInt(1));
                c.setFirstname(rs.getString(2));
                c.setLastname(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setAmount(rs.getFloat(5));
                list.add(c);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
