package view;

import Service.Audit;
import Service.DatabaseConn;
import model.User.User;
import persistence.GenericRepository;
import persistence.UserRepository;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
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

    public void startMenu() throws SQLException {
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

    private void signup() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Choose a type of account\n" +
                "1.Admin account\n" +
                "2.User account\n" +
                "3.Exit\n" +
                "5.End\n");

        option = scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1 -> {
                adminApp1.createAdmin();
                System.out.println("Account created successfully\n");
                login();
                adminApp1.showUsers();
                startMenu();

            }
            case 2 -> {
                userApp1.createUser();
                System.out.println("Account created successfully\n");
//                login();
                startMenu();
            }
            case 3 -> startMenu();
            default -> {
                System.out.println("Invalid option");
                signup();
            }
        }
    }

    private void login() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String username, password;

        System.out.println("Login:");
        System.out.println("Username");
        username = scanner.nextLine().trim();
        System.out.println("Password:");
        password = scanner.nextLine().trim();

        int id;

        id = adminApp1.validateLogin(username, password);
        if(id != -1) {
            adminApp1.setAdminID(id);
            adminApp1.startMenu();
            return;
        }



        System.out.println("Invalid username or password\n");
        startMenu();
    }
}
