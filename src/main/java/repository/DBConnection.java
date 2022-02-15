package repository;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class DBConnection {
    static String url = "jdbc:mysql://localhost:3306/calculator?useUnicode=true&serverTimezone=UTC";
    static String username = "root";
    static String password = "admin";
    static Connection connection;

    public DBConnection(){
        setConnection();
    }
    private void setConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            this.connection = DriverManager.getConnection(url,username,password);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }
    public Optional getConnection(){
        Optional optional = Optional.empty();
        if (connection!=null){
            optional = Optional.of(connection);
        }
            return optional;
        }

}
