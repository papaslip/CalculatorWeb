package enity;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private User user;
    List<Operation> operationStorage = new ArrayList<>();

    public Calculator(User user) {
        this.user = user;
    }

    public List<Operation> getOperationStorage(){
        return operationStorage;
    }

    public String resultOfOperation(double num1, double num2, String operator){
        double result = 0;
        if(operator.equals("+")){
                result = num1+num2;
         }else if(operator.equals("-")){
                result = num1-num2;
         }else if(operator.equals("*")){
                result = num1*num2;
         }else if(operator.equals("/")){
               result = num1/num2;
         }
        operationStorage.add(new Operation(user,num1,num2,operator,result));
    return num1+" "+operator+" "+num2+" = "+result;
    }

}
