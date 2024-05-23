package view;

import model.Article;
import model.User.Admin;
import model.User.User;
import persistence.ArticleRepository;
import persistence.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import static view.userApp.user;

public class adminApp extends Console {

    private static adminApp instance = null;

    private static Admin admin;
    private static int adminID;

    private adminApp(){
        userRepository = UserRepository.getInstance();
        articleRepository = ArticleRepository.getInstance();
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




    public int validateLogin(String username, String password){
        return userRepository.validateLogin(username, password);
    }

    public void setAdminID(int id) throws SQLException
    {
        adminID=id;
        User user2= userRepository.get(id);
        admin = user2.toAdmin(user2);
    }

    public static adminApp getInstance() {
        if (instance == null) {
            instance = new adminApp();
        }
        return instance;
    }

    public void showUsers()
    {
        ArrayList<User> users = userRepository.getAll();
        System.out.println("Users:");
        for (User user : users)
        {
            System.out.println(user.getUsername());

        }
    }

    public void showArticles()
    {
        ArrayList<Article> articles = articleRepository.getAll();
        System.out.println("Articles:");
        for (Article article : articles)
        {
            System.out.println(article.getName());
            System.out.println("\n");
        }
    }
    public void createArticle() {
        try {
            articleRepository.add(Article.createArticle());
        }
        catch (Exception e) {
            System.out.println("Something went wrong, please try other values");
            createArticle();
        }
    }


    public void deleteArticle()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduceti id-ul articolului de sters:");

        try{
            articleRepository.delete(articleRepository.get(sc.nextInt()));
            System.out.println("Articolul a fost sters!");

        }catch (Exception e)
        {
            System.out.println("Something went wrong, please try other values");
            deleteArticle();
        }
    }
    @Override
    public void startMenu() {
        audit.write(adminID, "Logged in");
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("\n\nWelcome  " + admin.getUsername() + "!");
        System.out.println("Choose your next action:\n" +
                "1.Show Users\n" +
                "2.Show Articles\n"+
                "3.Create Article\n"+
                "4.Delete Article\n"+
                "4.End");

        option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1 -> showUsers();
            case 2 -> showArticles();
            case 3 -> createArticle();
            case 4 -> deleteArticle();
            case 10 -> {
            }
        }
    }


}
