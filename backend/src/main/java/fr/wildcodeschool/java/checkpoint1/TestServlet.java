package fr.wildcodeschool.java.checkpoint1;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/api/test")
public class TestServlet extends HttpServlet  {

    private static final String MESSAGE = "Bravo %s, tu %s bien!";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logCall(req);
        resp.getWriter().printf(MESSAGE, getUser(), "GET");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logCall(req);
        resp.getWriter().printf(MESSAGE, getUser(), "POST");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logCall(req);
        resp.getWriter().printf(MESSAGE, getUser(), "PUT");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logCall(req);
        resp.getWriter().printf(MESSAGE, getUser(), "DELETE");
    }


    private void logCall(HttpServletRequest req) {
        log.info(req.getMethod() + " @ " + req.getRequestURI());
    }

    private String getUser() {
        return System.getProperty("user.name");
    }
}
