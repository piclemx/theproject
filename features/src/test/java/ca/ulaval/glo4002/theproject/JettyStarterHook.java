package ca.ulaval.glo4002.theproject;

import ca.ulaval.glo4002.theproject.core.JettyServer;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerContextFilter;
import cucumber.api.java.Before;

import java.util.Arrays;

public class JettyStarterHook {

    private static final int JETTY_TEST_PORT = 8080;

    private static boolean isFirstFeature = true;
    private JettyServer server;

    @Before
    public void beforeAll() throws Exception {
        if (isFirstFeature) {
            Runtime.getRuntime().addShutdownHook(new JettyServerShutdown());
            startJettyServer();
            isFirstFeature = false;
        }
    }

    private void startJettyServer() throws Exception {
        server = new JettyServer();
        TestContext context = new TestContext();
        context.reinitialize();
        server.start(JETTY_TEST_PORT, Arrays.asList(EntityManagerContextFilter.class));

    }

    private class JettyServerShutdown extends Thread {
        public void run() {
            try {
                server.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}