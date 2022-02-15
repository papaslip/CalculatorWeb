package service;

import dao.OperationDAO;
import repository.UserCreator;

public class UserService {
    private static UserService instance;
    static {
        instance = new UserService();
    }
    private UserService(){}

    public static UserService getInstance(){
        return instance;
    }

    public void addUser(String name,String userName, String pass, int question, String answer){
        UserCreator userCreator = new UserCreator();
        userCreator.createUser(name,userName, pass,question, answer);
    }
    public void addOperationToStorage(double num1,double num2,String operator,double result, int user, String data){
        OperationDAO operationCreator = new OperationDAO();
        operationCreator.createOperation(num1,num2,operator,result,user,data);
    }

}
