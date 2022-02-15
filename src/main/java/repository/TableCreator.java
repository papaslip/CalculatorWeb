package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class TableCreator {
    private DBConnection dbConnection;
    private Connection connection;

    public TableCreator(){
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
    public void createSecretQuestionTable(){

        if(connection!=null){
            try {
                Statement statement = connection.createStatement();
                statement.execute("create table SecretQuestion(idQuestion int auto_increment primary key,name varchar(45) not null)");
                statement.execute("insert into SecretQuestion(name) values ('Name of your pet?')");
                statement.execute("insert into SecretQuestion(name) values ('City were you born')");
                statement.execute("insert into SecretQuestion(name) values ('The name of the school where you studied')");
                statement.execute("insert into SecretQuestion(name) values ('Maiden name your mother')");
                statement.execute("insert into SecretQuestion(name) values ('Your favorite color')");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createUsersTable(){

        try {
            Statement statement = connection.createStatement();
            statement.execute("create table Users(ID int auto_increment primary key,Name varchar(45) not null,UserName varchar(45) not null,Pass varchar(45) not null,Question int not null,Answer varchar(45) not null,Position int not null," +
                    "FOREIGN KEY (Question) REFERENCES SecretQuestion(idQuestion) ON DELETE RESTRICT)");
            statement.execute("insert into Users(Name, UserName, Pass, Question, Answer, Position) values ('Admin', 'Admin', 'Admin', 1, 'Lisa', 2)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createStorageOfOperationTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute("create table StorageOfOperation(idOperation int auto_increment primary key,num1 double not null,num2 double not null,operator varchar(45) not null,result double not null,user int not null, data varchar(45) not null," +
                    "FOREIGN KEY (user) REFERENCES Users(ID) ON DELETE RESTRICT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
