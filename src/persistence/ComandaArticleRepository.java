package persistence;

import Service.DatabaseConn;
import model.ComandaArticle;
import model.User.Admin;
import model.User.User;
import oracle.jdbc.OraclePreparedStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComandaArticleRepository {

    DatabaseConn dbconn= DatabaseConn.getInstance();

    private static ComandaArticleRepository instance = null;
    private int id =0;

    public static ComandaArticleRepository getInstance() {
        if (instance == null) {
            instance = new ComandaArticleRepository();
        }
        return instance;
    }

    public void add(ComandaArticle comandaArticle) {
        String insertUser = "INSERT INTO ComandaArticle VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = (PreparedStatement)dbconn.getContext().prepareStatement(insertUser);

                preparedStatement.setInt(1,id);
                preparedStatement.setInt(2,comandaArticle.getIdArticol());
                preparedStatement.setInt(3,comandaArticle.getIdComanda());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }




}
