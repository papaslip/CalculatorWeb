package enity;

import java.util.Date;

public class Operation {
    private int id;
    private User user;
    private double num1;
    private double num2;
    private String operator;
    private double result;
    private String date;



    public Operation(User user, double num1, double num2, String operator, double result) {
        this.user = user;
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        this.result = result;
        this.date = String.valueOf(new Date(System.currentTimeMillis()));
    }

    public Operation(int id, double num1, double num2, String operator, double result, User user, String date) {
        this.id =id;
        this.user = user;
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        this.result = result;
        this.date = date;
    }

    public enity.User getUser() {
        return user;
    }

    public void setUser(enity.User user) {
        user = user;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }
    public String getIdString(){
        return String.valueOf(id);
    }

    @Override

    public String toString() {
        String operator2="/";
        if(operator.equals("sum")){
            operator2="+";
        } else if(operator.equals("sub")){
            operator2="-";
        } else if(operator.equals("mul")){
            operator2="*";
        }
        return num1+" "+operator2+" "+num2+" = "+result+" : "+date;
    }
}
