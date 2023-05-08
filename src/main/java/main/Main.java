package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AuthServlet;
import servlets.RegistryServlet;
import servlets.RequestServlet;

public class Main {
    public static void main( String[] args ) throws Exception {
        RegistryServlet registryServlet = new RegistryServlet();
        AuthServlet authServlet = new AuthServlet();
        RequestServlet requestServlet = new RequestServlet();

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(requestServlet), "/mirror");
        contextHandler.addServlet(new ServletHolder(registryServlet), "/registry");
        contextHandler.addServlet(new ServletHolder(authServlet), "/auth");

        Server server = new Server(8080);
        server.setHandler(contextHandler);

        server.start();
        server.join();
    }
}