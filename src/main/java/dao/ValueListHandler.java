package dao;

import enity.User;

import java.sql.SQLException;
import java.util.List;


public class ValueListHandler implements ValueListIterator{
    private OperationDAO operationDAO;
    private User user;
    private int index;
    public ValueListHandler(User user){
        this.operationDAO = new OperationDAO();
        this.user = user;
        this.index=0;

    }
    @Override
    public int getSize() {
        int count=0;
        try {
            count = operationDAO.getCount(user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List getCurrentElements() {
        List list=null;
        try {
            list = operationDAO.getOperationsByUser(user,index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List getPreviousElements() {
        if(index>=5){
            index = index-5;
        }else index = 0;

        List list=null;
        try {
            list = operationDAO.getOperationsByUser(user,index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List getNextElements() {
        System.out.println(getSize());
        if(index+5<getSize()){
            index = index+5;
        }
        List list=null;
        try {
            list = operationDAO.getOperationsByUser(user,index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
