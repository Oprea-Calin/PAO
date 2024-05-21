package persistence;

import Service.DatabaseConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface GenericRepository<T> {
    DatabaseConn dbconn= DatabaseConn.getInstance();

    public void add(T entity);

    public T get(int id) throws SQLException;

    public ArrayList<T> getAll();

    public void update(T entity);

    public void delete(T entity);


}
