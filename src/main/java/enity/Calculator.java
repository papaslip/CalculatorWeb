package enity;

public class Calculator {
    public Calculator() {
    }

    public String resultOfOperation(double num1, double num2, String operator){
        double result = 0;
        String mathoperator="+";
        if(operator.equals("sum")){
                result = num1+num2;
         }else if(operator.equals("sub")){
                result = num1-num2;
            mathoperator="-";
         }else if(operator.equals("mul")){
                result = num1*num2;
            mathoperator="*";
         }else if(operator.equals("div")){
               result = num1/num2;
            mathoperator="/";
         }
    return num1+" "+mathoperator+" "+num2+" = "+result;
    }
    public double resultDoubleOfOperation(double num1, double num2, String operator){
        double result = 0;
        String mathoperator="+";
        if(operator.equals("sum")){
            result = num1+num2;
        }else if(operator.equals("sub")){
            result = num1-num2;
            mathoperator="-";
        }else if(operator.equals("mul")){
            result = num1*num2;
            mathoperator="*";
        }else if(operator.equals("div")){
            result = num1/num2;
            mathoperator="/";
        }
        return result;
    }
}
