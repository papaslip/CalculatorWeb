package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserCreator {
    private DBConnection dbConnection = new DBConnection();
    private Connection connection = dbConnection.getConnection();

    public void createUser(String name,String userName, String pass, int question, String answer){
        if(connection!=null){
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement("insert into users (Name, UserName, Pass, Question, Answer, Position) values(?, ?, ?, ?, ?, ?)");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, userName);
                preparedStatement.setString(3, pass);
                preparedStatement.setInt(4, question);
                preparedStatement.setString(5, answer);
                preparedStatement.setInt(6, 1);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
