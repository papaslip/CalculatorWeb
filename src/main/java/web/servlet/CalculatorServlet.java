package web.servlet;
import enity.Calculator;
import enity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/calculator", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String operator = req.getParameter("operator");
            double num1double = (double) Double.parseDouble(num1);
            double num2double = (double) Double.parseDouble(num2);
            if(operator.equals("sum")||operator.equals("div")||operator.equals("sub")||operator.equals("mul")){
                Calculator calculator = new Calculator();
                UserService userService = UserService.getInstance();
                User user = (User) req.getSession().getAttribute("user");
                userService.addOperationToStorage(num1double,num2double,operator,calculator.resultDoubleOfOperation(num1double,num2double,operator),user.getId(),String.valueOf(new Date(System.currentTimeMillis())));
                req.setAttribute("calculatorMessage",calculator.resultOfOperation(num1double,num2double,operator));
                req.getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req,resp);
            }else req.setAttribute("ErrorMessage","Please, choose operator");
            req.getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req,resp);


    }
}
