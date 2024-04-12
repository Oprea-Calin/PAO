import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        User user =new User(1,"Calin", "Oprea");
        Customer cust = new Customer(2,"Calin", "Oprea", "email@gmaom","str Piinilor");
        List allUsers = new ArrayList();
        allUsers.add(user);
        allUsers.add(cust);


        Set<Article> articole = new HashSet<Article>();

        Article art1 = new Article(1,"Papuci Sport", "Papuci de alergare buni de sport", 249);
        Article art2 = new Article(2,"Pantofi Eleganti", "Papuci frumosi de mers la nunta", 450);
        Article art3 = new Article(3,"Slapi", "Incaltaminte de mers la mare", 30);

        articole.add(art1);
        articole.add(art2);
        articole.add(art3);


        System.out.printf("Hello and welcome!");


    }
}