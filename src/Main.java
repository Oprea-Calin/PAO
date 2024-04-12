import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        User user =new User(1,"Calin", "Oprea");
        Customer cust = new Customer(2,"Calin", "Oprea", "email@gmaom","str Piinilor");
        List allUsers = new ArrayList();
        allUsers.add(user);
        allUsers.add(cust);
        System.out.printf("Hello and welcome!");


    }
}