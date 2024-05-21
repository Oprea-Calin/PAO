package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {
    private static final String URL = "jdbc:mysql://localhost:3306/proiect_pao";
    private static final String USER = "root";
    private static final String PASSWORD = "123";

    private static Connection context;
    private static DatabaseConn instance;

    private DatabaseConn()
    {
        try {
            context = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
    public static DatabaseConn getInstance() {
        if (instance == null) {
            instance = new DatabaseConn();
        }
        return instance;
    }
    public static Connection getContext() {
        return context;
    }

    public static void setContext(Connection context) {
        DatabaseConn.context = context;
    }

    public static void setInstance(DatabaseConn instance) {
        DatabaseConn.instance = instance;
    }
}