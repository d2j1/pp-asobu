package com.httpserver.core;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerListenerThread extends Thread {

    private int port;
    private String webRoute;
    private ServerSocket serverSocket;

    private static final Logger LOGGER = Logger.getLogger(ServerListenerThread.class.getName());


    public ServerListenerThread(int port, String webRoute) throws IOException {
        this.port = port;
        this.webRoute = webRoute;
        this.serverSocket = new ServerSocket(this.port);
    }


    @Override
    public void run() {

        try {

            while( serverSocket != null && serverSocket.isBound() && !serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                LOGGER.info("Connection accepted " + socket.getInetAddress());

                HttpConnectionWorkerThread workerThread = new HttpConnectionWorkerThread(socket);
                workerThread.start();
            }


        } catch (IOException e) {
            LOGGER.info("Problem with setting socket "+ e.getMessage() );
        }finally {
            if( serverSocket != null ) {
                try {
                    serverSocket.close();
                } catch (IOException e) {}
            }
        }

    }
}
