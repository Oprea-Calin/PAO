package model;

import model.User.User;

import java.text.ParseException;
import java.util.Scanner;

public class Customer extends User {

    private String email;



    public Customer(int userId,String firstName, String lastName ,String email, String adresa, String password)
    {
        super(userId,firstName,lastName, adresa, password);
        this.email=email;

    }

    public Customer(int userId, Scanner in) throws ParseException{
        super(userId,"as","as","","");
        this.setUserId(userId);
        this.read(in);
    }
    public void read(Scanner in) throws ParseException {
        System.out.println("First name: ");
        this.setUsername(in.nextLine());
        System.out.println("Last name: ");
        this.setLastName(in.nextLine());
        System.out.println("Email:");
        this.setEmail(in.nextLine());

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





}