package model.User;

import java.util.Date;
import java.util.Scanner;

public class User {

    private int userId;

    private String firstName, lastName;


    public User(){}
    public User(int userId,String firstName, String lastName)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.userId=userId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int id){this.userId=id;}


    public void read() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter id: ");
        setUserId(sc.nextInt());

        System.out.print("Enter firstname: ");
        setFirstName(sc.nextLine());

        sc.nextLine();

        System.out.print("Enter lastname: ");
        setLastName(sc.nextLine());

    }

    public static User createUser(){
        Scanner sc = new Scanner(System.in);

        String first_name, last_name, id;

        System.out.println("ID: ");
        id = sc.nextLine();
        System.out.println("First name: ");
        first_name = sc.nextLine();
        System.out.println("Last name: ");
        last_name = sc.nextLine();

        return new User( Integer.parseInt(id),first_name, last_name);
    }



}
