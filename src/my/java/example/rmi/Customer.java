package my.java.example.rmi;

import java.io.Serializable;

public class Customer implements Serializable {

    private int acc_no;
    private String firstname, lastname, email;
    private float amount;

    public void setAcc_no(int acc_no) {
        this.acc_no = acc_no;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getAcc_no() {
        return acc_no;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public float getAmount() {
        return amount;
    }
}
