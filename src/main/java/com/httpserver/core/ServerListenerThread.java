package com.httpserver.core;

import com.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                // read the request

                // write the response
                String html = "<html> <head><title> Abuso Server</title> </head> <body>This is the response returned by the abuso server </body></html>";

                final String CRLF = "\n\r";

                String response =
                        "HTTP/1.1 200 OK" + CRLF + // status line - it has http version response_code response_message
                                "Content-Length: " + html.getBytes().length + CRLF // header
                                + CRLF +
                                html +
                                CRLF + CRLF;

                outputStream.write(response.getBytes());

                inputStream.close();
                ;
                outputStream.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
