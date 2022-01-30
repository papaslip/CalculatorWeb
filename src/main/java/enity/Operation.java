package enity;
import java.util.Date;

public class Operation {
    private User User;
    private double num1;
    private double num2;
    private String operator;
    private double result;
    private String date;

    public Operation(enity.User user, double num1, double num2, String operator, double result) {
        User = user;
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        this.result = result;
        this.date = String.valueOf(new Date(System.currentTimeMillis()));
    }

    @Override
    public String toString() {
        return num1+" "+operator+" "+num2+" = "+result+" : "+date;
    }
}
