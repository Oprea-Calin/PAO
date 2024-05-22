package model.User;

import java.util.Scanner;

public class User {

    private int userId;

    private String username, lastName, adresa, password;


    public User(){}
    public User(int userId,String firstName, String lastName, String adresa, String password)
    {
        this.username =firstName;
        this.lastName=lastName;
        this.userId=userId;
        this.adresa = adresa;
        this.password = password;
    }


    public Admin toAdmin(User user)
    {
        Admin admin = new Admin(user.userId, user.username,user.lastName, user.adresa, user.password, "", 0);
        return admin;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAdresa(){return adresa;}
    public void setAdresa(String adresa){this.adresa=adresa;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}


    public void read() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter id: ");
        setUserId(sc.nextInt());

        System.out.print("Enter firstname: ");
        setUsername(sc.nextLine());

        sc.nextLine();

        System.out.print("Enter lastname: ");
        setLastName(sc.nextLine());

    }

    public static User createUser(){
        Scanner sc = new Scanner(System.in);

        String first_name, last_name, id, fullname, password, adresa;

        System.out.println("ID: ");
        id = sc.nextLine();
        System.out.println("Username");
        first_name = sc.nextLine();
        System.out.println("Full name: ");
        fullname = sc.nextLine();
        System.out.println("Adresa ");
        adresa = sc.nextLine();
        System.out.println("Password ");
        password = sc.nextLine();

        return new User( Integer.parseInt(id),first_name, fullname, adresa, password );
    }



}
