package web.servlet;

import enity.User;

import repository.AccountVerification;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;


@WebServlet(urlPatterns = "/authorization", name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    private final UserStorage userStorage = new UserStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/logIn.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String pass = req.getParameter("pass");
        AccountVerification accountVerification = new AccountVerification();
        if(!accountVerification.checkUserName(userName)){
            req.setAttribute("message", "This user is not registered");
            req.getServletContext().getRequestDispatcher("/pages/logIn.jsp").forward(req,resp);
        }else {
            try {
                Optional optional = accountVerification.getUserByUsernameAndPass(userName,pass);
                if(optional.isPresent()){
                    User user = (User) accountVerification.getUserByUsernameAndPass(userName,pass).get();
                    req.getSession().setAttribute("user", user);
                    resp.sendRedirect("/");
                }else {
                    req.setAttribute("message", "This incorrect pass");
                    req.getServletContext().getRequestDispatcher("/pages/logIn.jsp").forward(req,resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
