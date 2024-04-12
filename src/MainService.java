import java.text.ParseException;
import java.util.*;

public class MainService {

    private static int id=0;
    List allUsers = new ArrayList();


    public MainService(){


//        User user =new User(1,"Calin", "Oprea");
//        Customer cust = new Customer(2,"Calin", "Oprea", "email@gmaom","str Piinilor");
//        List allUsers = new ArrayList();
//        allUsers.add(user);
//        allUsers.add(cust);
//
//
//        Set<Article> articole = new HashSet<Article>();
//
//        Article art1 = new Article(1,"Papuci Sport", "Papuci de alergare buni de sport", 249);
//        Article art2 = new Article(2,"Pantofi Eleganti", "Papuci frumosi de mers la nunta", 450);
//        Article art3 = new Article(3,"Slapi", "Incaltaminte de mers la mare", 30);
//
//        articole.add(art1);
//        articole.add(art2);
//        articole.add(art3);
//
//
//        System.out.printf("Hello and welcome!");

    }
    public void createCustomer(Scanner in) throws ParseException {

        Customer cust1 = new Customer(id++, in);
        allUsers.add(cust1);
        System.out.println("Customer created");
    }
    public void showCustomers()
    {if(allUsers.size()==0)
        System.out.println("Nu sunt clienti!");
        for(int i = 0; i<allUsers.size();i++)
        {

            System.out.println(allUsers.get(i));
        }

    }
}
