package web.servlet;
import enity.Operation;
import enity.User;
import repository.StorageOperations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/history", name = "HistoryServlet")
public class HistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StorageOperations storageOperations = new StorageOperations();
        User user = (User)req.getSession().getAttribute("user");
        try {
            List<Operation>list = storageOperations.getOperationsByUser(user);
            req.getSession().setAttribute("history", list);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req,resp);
    }
}
