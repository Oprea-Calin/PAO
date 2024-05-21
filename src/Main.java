import view.ConsoleApp;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.*;

public class Main {


    static List<String> commands = Arrays.asList("1.Creare cont client","2. Afisare clienti","3. Creare articol","4. Afisare articole","5. Creare model.User.Admin","6. Creare comanda", "7. Adauga articol la comanda","x. Iesire");

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        ConsoleApp consoleApp = ConsoleApp.getInstance();
        consoleApp.startMenu();
        /*Scanner in = new Scanner(System.in);
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
                    case "2" -> mainService.showAllUsers();
                    case "3" -> mainService.createArticle(in);
                    case "4" -> mainService.showArticles();
                    case "5" -> mainService.createAdmin(in);
                    case "6" -> mainService.createComanda(0);
                    case "7" -> mainService.addArticleToComanda(0, in);
                    case "x" -> x = true;
                }

            }catch (Exception e){
                System.out.println(e.toString());
            }
        }

*/

    }
}