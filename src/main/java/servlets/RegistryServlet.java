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
        String email = req.getParameter("email");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        if (!accountService.getUsersMap().containsKey(login)) {
            accountService.registry(login, password, email);
            printWriter.write(login + ", registry successfully");
        } else {
            printWriter.write("Login \"" + login + "\" is already used");
        }
        printWriter.close();
    }
}