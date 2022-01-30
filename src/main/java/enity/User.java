package enity;

public class User {
    String name;
    String userName;
    String pass;

    public User(String name, String userName, String pass) {
        this.name = name;
        this.userName = userName;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }
}
