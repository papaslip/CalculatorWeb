package service;
import repository.TableCreator;

public class AdminService {
    private static AdminService instance;
    static {
        instance = new AdminService();
    }
    private AdminService(){}

    public static AdminService getInstance(){
        return instance;
    }

    public void greatTables(){
        TableCreator tableCreator = new TableCreator();
//        tableCreator.createSecretQuestionTable();
//        tableCreator.createUsersTable();
        tableCreator.createStorageOfOperationTable();
    }
}
