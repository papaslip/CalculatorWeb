package enity;

public class User {
    private int id;
    private String name;
    private String userName;
    private String pass;
    private int question;
    private String answer;
    private int position;

    public User() {
    }

    public User(int id, String name, String userName, String pass, int question, String answer, int position) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.pass = pass;
        this.question = question;
        this.answer = answer;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
