package view;

import model.User.User;
import persistence.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class userApp extends Console {

    private static userApp instance= null;

    public static User user;
    private static int userId;

    private userApp() {
        userRepository = UserRepository.getInstance();
    }

    public void createUser() {
        try {
            userRepository.add(User.createUser());
        } catch (Exception e) {
            System.out.println("Something went wrong, please try other values");
            createUser();
        }
    }
    public static userApp getInstance() {
        if (instance == null) {
            instance = new userApp();
        }
        return instance;
    }

    public void setUserId(int id) throws SQLException {
        userId=id;
        User user2= userRepository.get(id);
        user = user2;
    }
    public int validateLogin(String username, String password){
        return userRepository.validateLogin(username, password);
    }

    @Override
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("\n\n\nWelcome  " + user.getUsername() + "!");


        option = scanner.nextInt();
        scanner.nextLine();

    }
}
