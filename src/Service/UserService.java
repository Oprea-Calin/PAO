package Service;

public class UserService {
    private static UserService instance = null;
    DatabaseConn dbConn = DatabaseConn.getInstance();
    public static UserService getInstance()
    {
        if(instance == null)
        {
            instance = new UserService();
        }
        return instance;
    }
}
