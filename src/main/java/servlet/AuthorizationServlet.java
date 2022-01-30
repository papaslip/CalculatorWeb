package servlet;
import enity.Calculator;
import enity.User;
import storage.UserStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
        User user = userStorage.getUser(userName);
        if(user==null){
            req.setAttribute("message", "This user is not registered");
            req.getServletContext().getRequestDispatcher("/pages/logIn.jsp").forward(req,resp);
        }else if(user.getPass().equals(pass)){
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("calculator", new Calculator(user));
            resp.sendRedirect("/");
        }else {
            req.setAttribute("message", "This incorrect pass");
            req.getServletContext().getRequestDispatcher("/pages/logIn.jsp").forward(req,resp);
        }
    }
}
