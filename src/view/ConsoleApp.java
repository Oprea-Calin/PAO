package view;

import Service.Audit;
import Service.DatabaseConn;
import model.User.User;
import persistence.GenericRepository;
import persistence.UserRepository;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;


public class ConsoleApp {

    private static ConsoleApp instance = null;
    private final adminApp adminApp1;
    private final userApp userApp1;

    private ConsoleApp(){
       adminApp1 = adminApp.getInstance();
       userApp1 = userApp.getInstance();
    }

    public static ConsoleApp getInstance(){
        if(instance == null){
            instance = new ConsoleApp();
        }
        return instance;
    }

    public void startMenu(){
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("StartMenu\n" +
                "1.Login\n" +
                "2.Signup\n" +
                "3.Exit\n");
        option = scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1 -> login();
            case 2 -> signup();
            case 3 -> {}
            default -> {
                System.out.println("Invalid option");
                startMenu();
            }
        }
    }

    private void signup(){
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Choose a type of account\n" +
                "1.Admin account\n" +
                "2.User account\n" +
                "3.Show users\n" +
                "4.Exit\n" +
                "5.End\n");

        option = scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1 -> {
                adminApp1.createAdmin();
                System.out.println("Account created successfully\n");
               // login();
                startMenu();
            }
            case 2 -> {
                userApp1.createUser();
                System.out.println("Account created successfully\n");
//                login();
                startMenu();
            }
            case 3 -> userApp1.createUser();
            case 4 -> startMenu();
            default -> {
                System.out.println("Invalid option");
                signup();
            }
        }
    }

    private void login(){
        Scanner scanner = new Scanner(System.in);
        String username, password;

        System.out.println("Login:");
        System.out.println("FirstName");
        username = scanner.nextLine().trim();
        System.out.println("Password:");
        password = scanner.nextLine().trim();

//        Map.Entry<Integer,Integer> ids = null;
//
//        ids = artistApp.validateLogin(username, password);
//        if(ids != null) {
//            artistApp.setArtist_id(ids.getValue());
//            artistApp.startMenu();
//            return;
//        }
//
//        ids = listenerApp.validateLogin(username, password);
//        if(ids != null) {
//            listenerApp.setListener_id(ids.getValue());
//            listenerApp.startMenu();
//            return;
//        }

        System.out.println("Invalid username or password\n");
        startMenu();
    }
}
