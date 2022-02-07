package web.servlet;
import repository.AccountVerification;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String userName = req.getParameter("userName");
        String pass = req.getParameter("pass");
        String answer = req.getParameter("answer");
        AccountVerification accountVerification = new AccountVerification();
        if(accountVerification.checkUserName(userName)){
            req.setAttribute("message", "This user is registered");
            req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req,resp);
        }else {
        try{
            int question = Integer.parseInt(req.getParameter("question"));
            UserService userService = UserService.getInstance();
            userService.addUser(name,userName,pass,question,answer);
        }catch (Exception e){
        }
        resp.sendRedirect("/");
        }
    }
}
