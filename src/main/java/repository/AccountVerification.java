package repository;

import enity.Operation;
import enity.User;

import java.sql.*;
import java.util.Optional;

public class AccountVerification {
    private DBConnection dbConnection;
    private Connection connection;

    public AccountVerification(){
        setConnection();
    }

    private void setConnection(){
       this.dbConnection = new DBConnection();
       Optional optional = dbConnection.getConnection();
       if(optional.isPresent()){
           this.connection = (Connection) optional.get();
       }else {

       }
    }

    public boolean checkUserName(String username){
        boolean x = false;
        try (PreparedStatement ps = connection.prepareStatement("select id from `Users` where `UserName` = ?")) {

            //
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    x=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    public Optional getUserByUsernameAndPass(String username, String pass) throws SQLException {

        Statement statement = connection.createStatement();
        User user = null;
        Optional returningUser = Optional.empty();
        ResultSet rs = statement.executeQuery("select * from users where `UserName` = '"+username+"'");
        while (rs.next()){
            if(rs.getString(4).equals(pass)){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int question = rs.getInt(5);
                String answer = rs.getString(6);
                int position = rs.getInt(7);
                user = new User(id,name,username,pass,question,answer,position);
               returningUser = Optional.of(user);
            }
        }
        return returningUser;
    }
}
