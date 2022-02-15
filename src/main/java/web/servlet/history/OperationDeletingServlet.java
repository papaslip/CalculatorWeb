package web.servlet.history;

import dao.OperationDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/deloperation")
public class OperationDeletingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        OperationDAO storageOperations = new OperationDAO();
        storageOperations.deleteOperationByid(id);
        resp.sendRedirect("/history");
    }
}
