package persistence;

import model.User.Admin;
import model.User.User;
import oracle.jdbc.OraclePreparedStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;


public class UserRepository implements GenericRepository<User> {
    private static UserRepository instance = null;
    private int id =0;
    private final Vector<User> users = new Vector<>();




    public UserRepository() {

    }
    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }




    public ArrayList<User> getAll_old() {
        ArrayList<User> allUsers = new ArrayList<>(users);
        return allUsers;
    }


    public void erase()
    {
        users.clear();
    }

    public int validateLogin(String username, String password) {

        String selectQuery = """
                SELECT userid
                FROM User 
                WHERE username = ? AND password = ?
             """;

        try {
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(selectQuery);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                int userId = res.getInt(1);
               return userId;
            } else {
                return -1; // No matching user found
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void add(User user) {
        String insertUser = "INSERT INTO User VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = (PreparedStatement)dbconn.getContext().prepareStatement(insertUser);
            if ( user.getClass() == Admin.class )
            {
                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,user.getUsername());
                preparedStatement.setString(3,  user.getLastName());
                preparedStatement.setString(4, ((Admin) user).getEmail());
                preparedStatement.setInt(5, ((Admin) user).getCod());
                preparedStatement.setString(6,user.getAdresa());
                preparedStatement.setString(7,user.getPassword());
            }
            else{
                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,user.getUsername());
                preparedStatement.setString(3,  user.getLastName());
                preparedStatement.setString(4,"notAdmin");
                preparedStatement.setInt(5,0);
                preparedStatement.setString(6, user.getAdresa());
                preparedStatement.setString(7, user.getPassword());
            }



            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }


    @Override
    public User get(int id) throws SQLException {
        String selectQuery = """
                                
                SELECT userid, username,lastname, email, password             
                    FROM User where userid = ?
                """;
        try {
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);

            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                User user = new User(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5)
                );
                return user;
            } else {
                throw new RuntimeException();
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    @Override
    public ArrayList<User> getAll() {
        String selectQuery = """
                    SELECT userid, username,lastname, email, password     
                    FROM User 
                """;
        try {
            PreparedStatement preparedStatement = (PreparedStatement)
                    dbconn.getContext().prepareStatement(selectQuery);
            ResultSet res = preparedStatement.executeQuery();

            ArrayList<User> users = new ArrayList<>();

            while (res.next()) {
                User user = new User(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5)

                );
                users.add(user);
            }
            return users;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(User obj) {
        String updateStatementArt = """
                    UPDATE user
                    SET
                        firstname = ?,
                        lastname= ? 
                    WHERE
                        userid = ?
                """;
        try {
            OraclePreparedStatement preparedStatement = (OraclePreparedStatement)
                    dbconn.getContext().prepareStatement(updateStatementArt);

            preparedStatement.setString(1, obj.getUsername());
            preparedStatement.setString(2, obj.getLastName());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        String updateStatementUser = """
                    
                UPDATE app_user
                    SET
                        first_name = ?,
                        last_name = ?,
                    WHERE 
                        userid = ?
                    """;

        try{
            OraclePreparedStatement preparedStatement = (OraclePreparedStatement)
                    dbconn.getContext().prepareStatement(updateStatementUser);

            preparedStatement.setString(1, obj.getUsername());
            preparedStatement.setString(2, obj.getLastName());


            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(User obj){
        String deleteStatementArt = """
                DELETE FROM user
                WHERE userid = ?
                 """;
        try{
            OraclePreparedStatement preparedStatement = (OraclePreparedStatement)
                    dbconn.getContext().prepareStatement(deleteStatementArt);

            preparedStatement.setInt(1, obj.getUserId());

            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }



    public User getByUsername(String username){
        String selectQuery = """
                                
                SELECT userid, username,lastname, email, password 
                                
                    FROM us.username = ?
                """;
        try {
            OraclePreparedStatement preparedStatement = (OraclePreparedStatement)
                    dbconn.getContext().prepareStatement(selectQuery);
            preparedStatement.setString(1, username);

            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                User user = new User(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5)
                );
                return user;
            } else {
                throw new RuntimeException();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
