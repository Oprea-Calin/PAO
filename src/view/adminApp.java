package view;

import model.User.Admin;
import model.User.User;
import persistence.UserRepository;

import java.util.Scanner;

public class adminApp extends Console {

    private static adminApp instance = null;

    private static Admin admin;
    private static int adminID;

    private adminApp(){
        userRepository = UserRepository.getInstance();
    }

    public void createAdmin() {
        try {
            userRepository.add(Admin.createAdmin());
        }
        catch (Exception e) {
            System.out.println("Something went wrong, please try other values");
            createAdmin();
        }
    }
    public static adminApp getInstance() {
        if (instance == null) {
            instance = new adminApp();
        }
        return instance;
    }
    @Override
    public void startMenu() {
        audit.write(adminID, "Logged in");
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("\n\n\nWelcome  " + admin.getFirstName() + "!!!");
        System.out.println("Choose your next action:\n" +
                "1.See your info\n" +
                "4.End");

        option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1 -> startMenu();
            case 3 -> {
            }
        }
    }


}
