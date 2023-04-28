package servlets;

import data.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registry")
public class RegistryServlet extends HttpServlet {
    AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        if (login == null || password == null) {
            resp.setStatus(400);
            printWriter.write("400 Bad Request. Empty Login/Password field.");
            return;
        }

        if (!accountService.getUsersMap().containsKey(login)) {
            accountService.registry(login, password);
            printWriter.write(login + ", registry successfully");
        } else {
            resp.setStatus(409);
            printWriter.write("409 Conflict. Login \"" + login + "\" is already used");
        }
        printWriter.close();
    }
}