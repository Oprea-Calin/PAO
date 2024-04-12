import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.*;

public class Main {


    static List<String> commands = Arrays.asList("1.Creare cont client","2. Afisare clienti","x. Iesire");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var x= false;

        for(int i =0;i<commands.size();i++)
        {
            System.out.println(commands.get(i));
        }

        MainService mainService = new MainService();


        while (!x){
            String command = in.nextLine().toLowerCase(Locale.ROOT);


            try{
                switch (command) {
                    case "1" -> mainService.createCustomer(in);
                    case "2" -> mainService.showCustomers();
                    case "x" -> x = true;
                }

            }catch (Exception e){
                System.out.println(e.toString());
            }
        }



    }
}