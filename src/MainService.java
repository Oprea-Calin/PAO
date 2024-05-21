import model.User.Admin;
import model.User.User;
import model.Article;
import model.Comanda;
import model.Customer;

import java.text.ParseException;
import java.util.*;

public class MainService {

    private static int id=0;
    private static int idArt=0;
    private static int idComanda=0;
    private List<Comanda> comenzi = new ArrayList();
    private List<User> allUsers = new ArrayList();
    private List<Article> articole = new ArrayList<>();

    public MainService(){


    }
    public void createCustomer(Scanner in) throws ParseException {

        Customer cust1 = new Customer(id++, in);
        allUsers.add(cust1);
        System.out.println("model.Customer created");
    }

    public void createArticle(Scanner in) throws ParseException{
        Article art1 = new Article(idArt++,in);
        articole.add(art1);
        System.out.println("Articol adaugat!");
    }
    public void showArticles()
    {
        if(articole.size()==0)
            System.out.println("Nu exista articole!");
        System.out.println(articole);
    }

    public void showAllUsers()
    {
        if(allUsers.size()==0)
            System.out.println("Nu sunt useri!");

        for(int i = 0; i<allUsers.size();i++)
        {

            System.out.println(allUsers.get(i));
        }

    }

    public int createComanda(int idUser)
    {
        Comanda comanda = new Comanda(idUser, idComanda++);
        comenzi.add(comanda);
        System.out.println("model.Comanda "+ (idComanda-1) + "s-a creat cu succes!");
        return idComanda-1;
    }
    public void addArticleToComanda(int idComanda, Scanner in)
    {
        System.out.println("ID-ul articolului de introdus in cos:");
        int idArticle = Integer.valueOf(in.nextLine());
        for(int i =0;i<comenzi.size();i++)
        {
            if(comenzi.get(i).getIdComanda() == idComanda)
            {
                for(int j =0;j<articole.size();j++)
                {
                    if (articole.get(j).getArticleId() == idArticle)
                    {
                        comenzi.get(i).addArticleToComanda(articole.get(j));
                        System.out.println("Articolul a fost adaugat cu succes!");
                    }

                }
            }
        }
    }

    public void createAdmin(Scanner in) throws ParseException{
        Admin admin1 = new Admin(id++,in);
        allUsers.add(admin1);
        System.out.println("model.User.Admin created");
    }

}
