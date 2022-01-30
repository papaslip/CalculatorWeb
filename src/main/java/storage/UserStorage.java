package storage;
import enity.User;
import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    public static final List<User> users = new ArrayList<>();
    public void addUsers(User user){
        users.add(user);
    }
    public User getUser(String userName){
        for (User user:users){
            if(user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }
    public List<User> getList(){
        return users;
    }


}
