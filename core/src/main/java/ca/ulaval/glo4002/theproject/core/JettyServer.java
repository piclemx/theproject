package ca.ulaval.glo4002.theproject.core;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class JettyServer {
    private final static String RESOURCES_PACKAGE = "ca.ulaval.glo4002.theproject";

    private Server server;

    public void start(int port) throws Exception {
        start(port, new ArrayList<Class<? extends Filter>>());
    }

    public void start(int port, List<Class<? extends Filter>> filters) throws Exception {
        server = new Server(port);
        ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/");
        for (Class<? extends Filter> filter : filters) {
            servletContextHandler.addFilter(filter, "/*", EnumSet.of(DispatcherType.REQUEST));
        }
        configurerJersey(servletContextHandler);
        server.start();
    }

    private void configurerJersey(ServletContextHandler servletContextHandler) {
        ServletContainer container = new ServletContainer(new ResourceConfig().packages(RESOURCES_PACKAGE).
                register(JacksonFeature.class));
        ServletHolder jerseyServletHolder = new ServletHolder(container);
        servletContextHandler.addServlet(jerseyServletHolder, "/*");
    }

    public void join() throws InterruptedException {
        server.join();
    }

    public void stop() throws Exception {
        if (server.isRunning()) {
            server.stop();
        }
    }

}
