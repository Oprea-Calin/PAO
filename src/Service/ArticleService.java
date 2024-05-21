package Service;

public class ArticleService {

    private static ArticleService instance = null;
    DatabaseConn dbConn = DatabaseConn.getInstance();

    private ArticleService(){}

    public static ArticleService getInstance()
    {
        if(instance == null)
        {
            instance = new ArticleService();
        }
        return instance;
    }



}
