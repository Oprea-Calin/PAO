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
        user.setUserId(id);
        user = userRepository.get(id);
    }
    public int validateLogin(String username, String password){
        return userRepository.validateLogin(username, password);
    }

    @Override
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("\n\n\nWelcome  " + User.createUser().getUsername() + "!!!");
        System.out.println("Choose your next action:\n" +
                "1.Show a few random songs\n" +
                "2.Search for a song\n" +
                "3.Search an artist\n" +
                "4.Show a few podcasts\n" +
                "5.Search a podcast\n" +
                "6.Listen to your queue\n" +
                "7.Show my likes\n" +
                "8.End\n");

        option = scanner.nextInt();
        scanner.nextLine();

    }
}
