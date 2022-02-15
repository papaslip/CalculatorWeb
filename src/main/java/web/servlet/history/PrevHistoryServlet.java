package web.servlet.history;

import dao.ValueListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/history/prev")
public class PrevHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValueListHandler valueListHandler = (ValueListHandler) req.getSession().getAttribute("valueListHandler");
        List list = valueListHandler.getPreviousElements();
        req.getSession().setAttribute("history", list);
        req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req,resp);
    }
}
