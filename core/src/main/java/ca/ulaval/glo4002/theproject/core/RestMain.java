package ca.ulaval.glo4002.theproject.core;

import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerContextFilter;

import java.util.Arrays;

public class RestMain {

    private final static int DEFAULT_PORT = 8080;

    private RestMain() {
    }

    public static void main(String[] args) throws Exception {
        new ContextBase().apply();
        JettyServer server = new JettyServer();
        server.start(DEFAULT_PORT, Arrays.asList(EntityManagerContextFilter.class));
        server.join();
    }
}
