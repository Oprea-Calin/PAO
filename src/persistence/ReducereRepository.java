package persistence;
import model.Reducere;
import model.User.Admin;
import model.User.User;
import oracle.jdbc.OraclePreparedStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ReducereRepository implements GenericRepository<Reducere>{

    private static ReducereRepository instance = null;
    private int reducereID=0;
    private final Vector<Reducere> reduceri = new Vector<>();

    public static ReducereRepository getInstance(){
            if (instance == null) {
                instance = new ReducereRepository();
            }
            return instance;

    }
    @Override
    public void add(Reducere reducere) {
        String insertUser = "INSERT INTO reduceri VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = (PreparedStatement)dbconn.getContext().prepareStatement(insertUser);

                preparedStatement.setInt(1,reducereID);
                preparedStatement.setInt(2,reducere.getArticleId());
                preparedStatement.setInt(3,  reducere.getReducere());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }


    @Override
    public Reducere get(int id) throws SQLException {
        String selectQuery = """
                                
                SELECT reducereId, articleId, reducere         
                    FROM reduceri where reducereId = ?
                """;
        try {
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);

            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                Reducere reducere = new Reducere(
                        res.getInt(1),
                        res.getInt(2),
                        res.getInt(3)
                );
                return reducere;
            } else {
                throw new RuntimeException();
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    @Override
    public ArrayList<Reducere> getAll() {
        String selectQuery = """
                    SELECT reducereId, articleId, reducere       
                    FROM reduceri 
                """;
        try {
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(selectQuery);
            ResultSet res = preparedStatement.executeQuery();

            ArrayList<Reducere> reduceri = new ArrayList<>();

            while (res.next()) {
                Reducere reducere = new Reducere(
                        res.getInt(1),
                        res.getInt(2),
                        res.getInt(3)

                );
                reduceri.add(reducere);
            }
            return reduceri;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Reducere obj) {
        String updateStatementArt = """
                    UPDATE user
                    SET
                        reducere
                    WHERE
                        reducereId = ?
                """;
        try {
            OraclePreparedStatement preparedStatement = (OraclePreparedStatement)
                    dbconn.getContext().prepareStatement(updateStatementArt);

            preparedStatement.setInt(1, obj.getReducereId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void delete(Reducere obj){
        String deleteStatementArt = """
                DELETE FROM reduceri
                WHERE reducereId = ?
                 """;
        try{
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(deleteStatementArt);

            preparedStatement.setInt(1, obj.getReducereId());

            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

}
