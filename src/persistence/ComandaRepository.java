package persistence;

import model.Comanda;
import model.User.Admin;
import model.User.User;
import oracle.jdbc.OraclePreparedStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ComandaRepository implements GenericRepository<Comanda> {
    private static ComandaRepository instance = null;

    private int id =0;
    private final Vector<Comanda> comenzi = new Vector<>();

    public ComandaRepository(){

    }
    public static ComandaRepository getInstance()
    {
        if ( instance == null)
        {
            instance = new ComandaRepository();
        }
        return instance;
    }

    public ArrayList<Comanda> getComenziUser(int id) {
        String selectQuery = """
                    SELECT  userId, comandaId, adresaLivrare       
                    FROM Comanda where userId = ?
                """;
        try {
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);

            ResultSet res = preparedStatement.executeQuery();

            ArrayList<Comanda> comenzi = new ArrayList<>();

            while (res.next()) {
                Comanda comanda = new Comanda(
                        res.getInt(1),
                        res.getInt(2),
                        res.getString(3)

                );
                comenzi.add(comanda);
            }
            return comenzi;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Override
    public void add(Comanda comanda) {
        String insertUser = "INSERT INTO Comanda VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = (PreparedStatement)dbconn.getContext().prepareStatement(insertUser);


            preparedStatement.setInt(1,comanda.getIdComanda());
                preparedStatement.setInt(2,comanda.getIdUser());
                preparedStatement.setString(3,comanda.getAdresaLivrare());



            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }


    @Override
    public Comanda get(int id) throws SQLException {
        String selectQuery = """
                                
                SELECT comandaId, userId, adresaLivrare           
                    FROM Comanda where comandaId = ?
                """;
        try {
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);

            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                Comanda comanda = new Comanda(
                        res.getInt(1),
                        res.getInt(2),
                        res.getString(3)
                );
                return comanda;
            } else {
                throw new RuntimeException();
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    @Override
    public ArrayList<Comanda> getAll() {
        String selectQuery = """
                    SELECT  userId, comandaId, adresaLivrare       
                    FROM Comanda
                """;
        try {
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(selectQuery);
            ResultSet res = preparedStatement.executeQuery();

            ArrayList<Comanda> comenzi = new ArrayList<>();

            while (res.next()) {
                Comanda comanda = new Comanda(
                        res.getInt(1),
                        res.getInt(2),
                        res.getString(3)

                );
                comenzi.add(comanda);
            }
            return comenzi;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Comanda obj) {
        String updateStatementArt = """
                    UPDATE user
                    SET
                        adresaLivrare = ? 
                    WHERE
                        comandaId = ?
                """;
        try {
            OraclePreparedStatement preparedStatement = (OraclePreparedStatement)
                    dbconn.getContext().prepareStatement(updateStatementArt);

            preparedStatement.setString(1, obj.getAdresaLivrare());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void delete(Comanda obj){
        String deleteStatementArt = """
                DELETE FROM Comanda
                WHERE comandaId = ?
                 """;
        try{
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(deleteStatementArt);

            preparedStatement.setInt(1, obj.getIdComanda());

            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }



}
