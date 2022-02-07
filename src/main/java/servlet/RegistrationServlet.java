package servlet;
import enity.User;
import repository.DBConnection;
import service.UserService;
import storage.UserStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private UserStorage userStorage = new UserStorage();
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
        try{
            int question = Integer.parseInt(req.getParameter("question"));
            UserService userService = UserService.getInstance();
            userService.addUser(name,userName,pass,question,answer);
        }catch (Exception e){

        }



        resp.sendRedirect("/");
    }
}
