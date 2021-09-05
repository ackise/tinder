package com.tinder.repository;


import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class JettyServer {
    private final Server server = new Server();

    public void start() {
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);

        server.setConnectors(new Connector[]{connector});

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
