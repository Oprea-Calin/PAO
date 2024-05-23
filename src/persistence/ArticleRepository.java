package persistence;

import model.Article;
import model.User.Admin;
import model.User.User;
import oracle.jdbc.OraclePreparedStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ArticleRepository implements GenericRepository<Article>{

    private static ArticleRepository instance = null;
    private int id = 0;
    private final Vector<Article> articles = new Vector<>();

    public static ArticleRepository getInstance() {
        if (instance == null) {
            instance = new ArticleRepository();
        }
        return instance;
    }

    @Override
    public void add(Article article) {
        String insertArticle = "INSERT INTO Article VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = (PreparedStatement)dbconn.getContext().prepareStatement(insertArticle);

                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,article.getName());
                preparedStatement.setString(3,  article.getDescription());
                preparedStatement.setInt(4, article.getPrice());


            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public Article get(int id) throws SQLException {
        String selectQuery = """
                                
                SELECT articleId, titlu, descriere, pret          
                    FROM Article where articleid = ?
                """;
        try {
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);

            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                Article article = new Article(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4)
                );
                return article;
            } else {
                throw new RuntimeException();
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    @Override
    public ArrayList<Article> getAll() {
        String selectQuery = """
                    SELECT articleId, titlu, descriere, pret          
                    FROM Article
                """;
        try {
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(selectQuery);
            ResultSet res = preparedStatement.executeQuery();

            ArrayList<Article> articles = new ArrayList<>();

            while (res.next()) {
                Article article = new Article(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4)

                );
                articles.add(article);
            }
            return articles;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Article obj) {
        String updateStatementArt = """
                    UPDATE Article
                    SET
                        titlu = ?,
                        descriere= ?
                        pret = ? 
                    WHERE
                        articleid = ?
                """;
        try {
            OraclePreparedStatement preparedStatement = (OraclePreparedStatement)
                    dbconn.getContext().prepareStatement(updateStatementArt);

            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getDescription());
            preparedStatement.setInt(3, obj.getPrice());


            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Article obj){
        String deleteStatementArt = """
                DELETE FROM Article
                WHERE articleid = ?
                 """;
        try{
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(deleteStatementArt);

            preparedStatement.setInt(1, obj.getArticleId());

            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
