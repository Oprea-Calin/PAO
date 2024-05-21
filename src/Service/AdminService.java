package Service;

public class AdminService {
    private static AdminService instance = null;
    DatabaseConn dbConn = DatabaseConn.getInstance();
    public static AdminService getInstance()
    {
        if(instance == null)
        {
            instance = new AdminService();
        }
        return instance;
    }
}
