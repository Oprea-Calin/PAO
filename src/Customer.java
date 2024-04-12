import java.text.ParseException;
import java.util.Scanner;

public class Customer extends User {

    private String email;
    private String address;



    public Customer(int userId,String firstName, String lastName ,String email, String address)
    {
        super(userId,firstName,lastName);
        this.email=email;
        this.address=address;
    }

    public Customer(int userId, Scanner in) throws ParseException{
        super(userId,"as","as");
        this.setUserId(userId);
        this.read(in);
    }
    public void read(Scanner in) throws ParseException {
        System.out.println("First name: ");
        this.setFirstName(in.nextLine());
        System.out.println("Last name: ");
        this.setLastName(in.nextLine());
        System.out.println("Email:");
        this.setEmail(in.nextLine());
        System.out.println("Address:");
        this.setAdress(in.nextLine());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getAdress() {
        return address;
    }
    public void setAdress(String address) {
        this.address = address;
    }




}