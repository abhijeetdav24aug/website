package ua.com.itinterview.utils;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyTestWebServerDeployer {

    private static final int DEFAULT_PORT = 8080;

    private Server server;
    private int port;

    public JettyTestWebServerDeployer() {
	port = DEFAULT_PORT;
    }

    public JettyTestWebServerDeployer(int port) {
	this.port = port;
    }

    public static void main(String[] args) {
	JettyTestWebServerDeployer jettyTestServer = new JettyTestWebServerDeployer();
	jettyTestServer.start();
    }

    public void start() {
	server = new Server(port);
	WebAppContext context = new WebAppContext();
	context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
	context.setResourceBase("src/main/webapp");
	context.setContextPath("/it-interview");
	context.setParentLoaderPriority(true);

	server.setHandler(context);

	try {
	    server.start();
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    public void stop() throws Exception {
	server.stop();
    }

    public Server getServer() {
	return server;
    }

    public void setServer(Server server) {
	this.server = server;
    }

    public int getPort() {
	return port;
    }

    public void setPort(int port) {
	this.port = port;
    }

}
