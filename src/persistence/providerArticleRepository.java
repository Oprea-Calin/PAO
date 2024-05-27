package persistence;

import Service.DatabaseConn;
import model.ComandaArticle;
import model.providerArticol;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class providerArticleRepository {

    DatabaseConn dbconn= DatabaseConn.getInstance();

    private static providerArticleRepository instance = null;

    public static providerArticleRepository getInstance(){
        if (instance == null) {
            instance = new providerArticleRepository();
        }
        return instance;
    }

    public void add(providerArticol providerArticle) {
        String insertUser = "INSERT INTO providerArticol VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = (PreparedStatement)dbconn.getContext().prepareStatement(insertUser);

            preparedStatement.setInt(1,providerArticle.getIdProvider());
            preparedStatement.setInt(2,providerArticle.getIdArticol());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }


}
