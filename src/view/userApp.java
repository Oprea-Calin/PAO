package view;

import model.Comanda;
import model.ComandaArticle;
import model.User.User;
import persistence.ArticleRepository;
import persistence.ComandaArticleRepository;
import persistence.ComandaRepository;
import persistence.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class userApp extends Console {

    private static userApp instance= null;

    public static User user;
    private static int userId;

    private userApp() {
        userRepository = UserRepository.getInstance();
        articleRepository = ArticleRepository.getInstance();
        comandaRepository = ComandaRepository.getInstance();
        comandaArticleRepository = ComandaArticleRepository.getInstance();
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

    public void addArticleToComanda(int id)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Id articol:");
        int idArt = sc.nextInt();
        try{
            comandaArticleRepository.add(new ComandaArticle(id, idArt));

        }catch (Exception e)
        {
            System.out.println("Something went wrong, please try other values");
        }

        System.out.println(
                "1.Adaugare produs la comanda\n" +
                "2.Back\n");

        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1 -> {addArticleToComanda(id); }
            case 2 -> {break;}
            case 10 -> {
            }
        }

    }

    public void createComanda()
    {
        ArrayList<Comanda> comenzi = comandaRepository.getAll();
        int idnext=0;
        if(comenzi.size()>0)
        {
            idnext= comenzi.get(comenzi.size()-1).getIdComanda()+1;
        }



        try{
            Scanner sc = new Scanner(System.in);
            String adresa;
            int option;

            System.out.println("Adresa ");
            adresa = sc.nextLine();

            comandaRepository.add(new Comanda(user.getUserId(),idnext, adresa));

            System.out.println("Selectati urmatoarea actiune pentru comanda creata:\n" +
                    "1.Adaugare produs la comanda\n" +
                    "2.Trimite comanda\n");

            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> {addArticleToComanda(idnext); }
                case 2 -> {break;}
                case 10 -> {
                }
            }


        }catch (Exception e)
        {
            System.out.println("Something went wrong, please try other values");
        }
    }







    @Override
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("\nWelcome  " + user.getUsername() + "!!!");

        System.out.println("Choose your next action:\n" +
                "1.Create Comanda\n"
                );

        option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1 -> createComanda();

            case 10 -> {
            }
        }

        option = scanner.nextInt();
        scanner.nextLine();

    }
}
