package persistence;

import model.Comanda;
import model.Provider;
import oracle.jdbc.OraclePreparedStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProviderRepository implements GenericRepository<Provider>{

    public static ProviderRepository instance = null;




    public static ProviderRepository getInstance(){
        if (instance == null) {
            instance = new ProviderRepository();
        }
        return instance;

    }


    @Override
    public void add(Provider provider) {
        String insertProvider = "INSERT INTO Provider VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = (PreparedStatement)dbconn.getContext().prepareStatement(insertProvider);


            preparedStatement.setInt(1,provider.getIdProvider());
            preparedStatement.setString(2,provider.getNume());
            preparedStatement.setString(3,provider.getAdresa());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }


    @Override
    public Provider get(int id) throws SQLException {
        String selectQuery = """
                                
                SELECT providerId, numeProvider, adresaProvider          
                    FROM Provider where providerId = ?
                """;
        try {
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);

            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                Provider provider = new Provider(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3)
                );
                return provider;
            } else {
                throw new RuntimeException();
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    @Override
    public ArrayList<Provider> getAll() {
        String selectQuery = """
                    SELECT  providerId, numeProvider, adresaProvider      
                    FROM Provider
                """;
        try {
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(selectQuery);
            ResultSet res = preparedStatement.executeQuery();

            ArrayList<Provider> provideri= new ArrayList<>();

            while (res.next()) {
                Provider provider = new Provider(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3)

                );
                provideri.add(provider);
            }
            return provideri;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Provider obj) {
        String updateStatementArt = """
                    UPDATE Provider
                    SET
                        adresaProvider = ? 
                    WHERE
                        providerId = ?
                """;
        try {
            OraclePreparedStatement preparedStatement = (OraclePreparedStatement)
                    dbconn.getContext().prepareStatement(updateStatementArt);

            preparedStatement.setString(1, obj.getAdresa());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void delete(Provider obj){
        String deleteStatementArt = """
                DELETE FROM Provider
                WHERE providerId = ?
                 """;
        try{
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(deleteStatementArt);

            preparedStatement.setInt(1, obj.getIdProvider());

            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

}
