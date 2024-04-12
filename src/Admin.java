import java.text.ParseException;
import java.util.Scanner;

public class Admin extends User{

    private String email;

    private int codAcces;

    public Admin(int userId,String firstName, String lastName ,String email, int codAcces)
    {
        super(userId, firstName, lastName);
        this.email=email;
        this.codAcces=codAcces;
    }

    public Admin(int userId, Scanner in) throws ParseException{
        super(userId,"","");
        this.setUserId(userId);
        this.read(in);
    }

    public void read(Scanner in) throws ParseException{
        System.out.println("First Name:");
        this.setFirstName(in.nextLine());
        System.out.println("Last Name:");
        this.setLastName(in.nextLine());
        System.out.println("Email:");
        this.setEmail(in.nextLine());
        System.out.println("Cod Acces:");
        this.setCodAcces(in.nextLine());

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCodAcces(String codAcces) {
        this.codAcces = Integer.valueOf(codAcces);
    }



}
