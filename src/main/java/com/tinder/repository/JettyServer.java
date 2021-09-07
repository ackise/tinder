package com.tinder.repository;

import com.tinder.repository.controllers.LikedServlet;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyServer {
    private final Server server = new Server();;

    public void start() {
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);

        server.setConnectors(new Connector[]{connector});

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(LikedServlet.class, "/liked");

        server.setHandler(handler);

        try {
            server.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
