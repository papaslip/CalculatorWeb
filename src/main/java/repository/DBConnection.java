package repository;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static String url = "jdbc:mysql://localhost:3306/calculator?useUnicode=true&serverTimezone=UTC";
    static String username = "root";
    static String password = "admin";
    static Connection badConnection = null;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(url,username,password);
            return  connection;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return badConnection;
        }
    }
}
