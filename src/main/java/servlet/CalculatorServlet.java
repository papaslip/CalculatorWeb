package servlet;
import enity.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        try{
            double num1double = (double) Integer.parseInt(num1);
            double num2double = (double) Integer.parseInt(num2);
            if(operator.equals("+")||operator.equals("-")||operator.equals("/")||operator.equals("*")){
                Calculator calculator = (Calculator) req.getSession().getAttribute("calculator");
                req.setAttribute("calculatorMessage",calculator.resultOfOperation(num1double,num2double,operator));
                req.getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req,resp);
            }else req.setAttribute("calculatorMessage","You enter incorrect operator");
            req.getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req,resp);
        }catch (NumberFormatException e){
            req.setAttribute("calculatorMessage","You didn't enter number. Check if the numbers are correct");
            req.getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req,resp);
        }

    }
}
