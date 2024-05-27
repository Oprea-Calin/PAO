package view;

import model.*;
import model.User.Admin;
import model.User.User;
import persistence.*;

import java.sql.SQLException;
import java.util.*;

import static view.userApp.user;

public class adminApp extends Console {

    private static adminApp instance = null;

    private static Admin admin;
    private static int adminID;

    private adminApp(){
        userRepository = UserRepository.getInstance();
        articleRepository = ArticleRepository.getInstance();
        reducereRepository = ReducereRepository.getInstance();
        providerRepository = ProviderRepository.getInstance();
        providerArticleRepository = persistence.providerArticleRepository.getInstance();
    }

    public void createAdmin() {
        try {
            userRepository.add(Admin.createAdmin());
        }
        catch (Exception e) {
            System.out.println("Something went wrong");
            createAdmin();
        }
    }

    public void Audit(int id)
    {
        audit.write(id, "Logged in");
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
        startMenu();
    }

    public void showArticles()
    {
        ArrayList<Article> articles = articleRepository.getAll();

        Collections.sort(articles);
        System.out.println("Articles:");
        for (Article article : articles)
        {
            System.out.println(article.getArticleId());
            System.out.println(article.getName());
            System.out.println(article.getDescription());
            System.out.println(article.getPrice() + " ron");

            System.out.println("\n");
        }
        startMenu();
    }
    public void addProviderToArticle(int idArticle)
    {

        ArrayList<Provider> providers = providerRepository.getAll();
        int idnext=0;
        if(providers.size()>0)
        {
            idnext= providers.get(providers.size()-1).getIdProvider()+1;
        }
        providerRepository.add(Provider.createProvider(idnext));
        int idProvider = idnext;


        try{

            providerArticleRepository.add(new providerArticol(idProvider, idArticle));

        }catch (Exception e)
        {
            System.out.println("Something went wrong");
        }


    }
    public void createArticle() {

        ArrayList<Article> article = articleRepository.getAll();
        int idn=0;
        if(article.size()>0)
        {
            idn= article.get(article.size()-1).getArticleId()+1;
        }


        try {

            articleRepository.add(Article.createArticle());
        }
        catch (Exception e) {
            System.out.println("Something went wrong");
            createArticle();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Selectati urmatoarea actiune pentru comanda creata:\n" +
                "1.Adaugare provider pentru articol\n" +
                "2.Back\n");
        int option;
        option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1 -> {addProviderToArticle(idn); }
            case 2 -> {

                startMenu();
            }
            case 10 -> {
            }
        }



        startMenu();
    }

    public void createReducere(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Id reducere:");
        int idRed = sc.nextInt();
        System.out.println("Id articol:");
        int idArt = sc.nextInt();
        System.out.println("Reducere");
        int reducere = sc.nextInt();

        try{
            ArrayList<Reducere> reduceri =  reducereRepository.getAll();

            for (Reducere reducere1: reduceri ){
                if( reducere1.getArticleId() == idArt)
                {
                    reducereRepository.delete(reducere1);

                }
            }
            reducereRepository.add(new Reducere(idRed,idArt,reducere));

        }catch (Exception e){
            System.out.println("Something went wrong");
            createReducere();
        }
        startMenu();
    }

    @Override
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("\n\nWelcome  " + admin.getUsername() + "!");
        System.out.println("Choose your next action:\n" +
                "1.Show Users\n" +
                "2.Show Articles\n"+
                "3.Create Article\n"+
                "4.Add discount for an article\n"+
                "5.End");

        option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1 -> showUsers();
            case 2 -> showArticles();
            case 3 -> createArticle();
            case 4 -> createReducere();
            case 10 -> {
            }
        }
    }


}
