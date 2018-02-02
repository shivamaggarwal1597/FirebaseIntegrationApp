package com.example.shivam.firebaseintegrationtutorial;

/**
 * Created by shivam on 1/2/18.
 */

public class MyUser {
    public String name;
    public String rollno;

    public MyUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public MyUser(String name, String rollno) {
        this.name = name;
        this.rollno = rollno;
    }
}
