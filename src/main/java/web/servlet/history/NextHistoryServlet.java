package web.servlet.history;

import dao.ValueListHandler;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/history/next")
public class NextHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValueListHandler valueListHandler = (ValueListHandler) req.getSession().getAttribute("valueListHandler");
        List list = valueListHandler.getNextElements();
        req.getSession().setAttribute("history", list);
        req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req,resp);
    }
}
