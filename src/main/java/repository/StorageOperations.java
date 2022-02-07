package repository;
import enity.Operation;
import enity.User;

import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StorageOperations {
    private DBConnection dbConnection = new DBConnection();
    private Connection connection = dbConnection.getConnection();

    public void createOperation(double num1, double num2, String operator, double result, int user, String data){
        if(connection!=null){
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement("insert into storageofoperation (num1, num2, operator, result, user, data) values(?, ?, ?, ?, ?, ?)");
                preparedStatement.setDouble(1, num1);
                preparedStatement.setDouble(2, num2);
                preparedStatement.setString(3, operator);
                preparedStatement.setDouble(4, result);
                preparedStatement.setInt(5, user);
                preparedStatement.setString(6, data);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    public CopyOnWriteArrayList getOperationsByUser(User user) throws SQLException {
        List<Operation> list = new CopyOnWriteArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from storageofoperation where `user` = '"+user.getId()+"'");
        while (rs.next()){
                int id = rs.getInt(1);
                double num1 = rs.getDouble(2);
                double num2 = rs.getDouble(3);
                String operator = rs.getString(4);
                double result = rs.getDouble(5);
                String data = rs.getString(7);
                Operation operation = new Operation(id,num1,num2,operator,result,user,data);
                list.add(operation);
        }
        return (CopyOnWriteArrayList) list;
    }

    public void deleteOperationByid(int id){
        if(connection!=null){
            Statement deleteSratement = null;
            try {
                deleteSratement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                deleteSratement.execute("delete from storageofoperation where idOperation = '"+id+"'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
