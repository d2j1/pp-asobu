package com.httpserver;

import com.httpserver.config.Configuration;
import com.httpserver.config.ConfigurationManager;
import com.httpserver.core.ServerListenerThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class HttpServer {

    private static final Logger LOGGER = Logger.getLogger(HttpServer.class.getName());
    public static void main(String[] args) {

        LOGGER.info("Starting server....");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        LOGGER.info("Using Port "+conf.getPort());
        LOGGER.info("Using Webroute "+conf.getWebroute());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroute());
            serverListenerThread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
