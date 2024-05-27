package view;

import model.Article;
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

    public void Audit(int id)
    {
        audit.write(id, "Logged in");
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
            case 2 -> {
                System.out.println("Selectati urmatoarea actiune pentru comanda creata:\n" +
                        "1.Adaugare produs la comanda\n" +
                        "2.Trimite comanda\n");
                break;}
            case 10 -> {
            }
        }

    }

    public void showComenziUser(int id)
    {
        ArrayList<Comanda> comenzi = comandaRepository.getComenziUser(id);
        System.out.println("Comenzile userului: " + user.getUsername() + ":");
        for( Comanda comanda : comenzi)
        {
            System.out.println("ID comanda:");
            System.out.println(comanda.getIdComanda());
            System.out.println("Adresa livrare:");
            System.out.println(comanda.getAdresaLivrare());
            System.out.println("\n");
        }
        startMenu();
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
                case 2 -> {

                    startMenu();
                }
                case 10 -> {
                }
            }


        }catch (Exception e)
        {
            System.out.println("Something went wrong, please try other values");
        }
    }
    public void showArticles()
    {
        ArrayList<Article> articles = articleRepository.getAll();

        System.out.println("Articles:");
        for (Article article : articles)
        {
            System.out.println(article.getArticleId());

            System.out.println(article.getName());

            System.out.println(article.getDescription());
            System.out.println("\n");
        }
        startMenu();
    }
    @Override
    public void startMenu() {

        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("\nWelcome  " + user.getUsername() + "!!!");

        System.out.println("Choose your next action:\n" +
                "1.Create Comanda\n"+
                "2.Afisare Comenzi User\n" +
                "3.Afisare Articole"
                );

        option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1 -> createComanda();
            case 2 -> showComenziUser(userId);
            case 3 -> showArticles();

            case 10 -> {
            }
        }

        option = scanner.nextInt();
        scanner.nextLine();

    }
}
