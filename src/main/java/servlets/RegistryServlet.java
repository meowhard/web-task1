package servlets;

import data.AccountDataSet;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        AccountService accountService = new AccountService();
        AccountDataSet account = new AccountDataSet(login, password);

        if (login == null || password == null) {
            resp.setStatus(400);
            printWriter.write("400 Bad Request. Empty Login/Password field.");
            return;
        }

        if (accountService.findAccountInDB(login) == null) {
            accountService.registry(account);
            printWriter.write(login + ", registry successfully");
        } else {
            resp.setStatus(409);
            printWriter.write("409 Conflict. Login \"" + login + "\" is already used");
        }
        printWriter.close();
    }
}