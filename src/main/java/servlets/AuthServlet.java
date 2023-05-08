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

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        AccountService accountService = new AccountService();
        AccountDataSet accountFromDB = accountService.findAccountInDB(login);

        if ((accountFromDB != null) && accountFromDB.getPassword().equals(password)) {
            printWriter.write("Hello, " + login);
        } else {
            resp.setStatus(401);
            printWriter.write("401 Unauthorized. Missing login:password combination");
        }
        printWriter.close();
    }
}