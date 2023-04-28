package servlets;

import data.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        if (!accountService.getUsersMap().containsKey(login) ||
                !(accountService.getUsersMap().get(login)).getPassword().equals(password)) {
            resp.setStatus(401);
            printWriter.write("401 Unauthorized. Missing login:password combination");
        } else {
            printWriter.write("Hello, " + login);
        }
        printWriter.close();
    }
}