package com.httpserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class HttpConnectionWorkerThread extends Thread {

    private static final Logger LOGGER = Logger.getLogger(HttpConnectionWorkerThread.class.getName());

    private Socket socket;

    public HttpConnectionWorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {

             inputStream = socket.getInputStream();
             outputStream = socket.getOutputStream();

            // read the request

//            // below prints the headers of the requests
//            int d ;
//
//            while( ( d = inputStream.read() ) != -1 ) {
//                System.out.print((char)d);
//            }

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




            LOGGER.info("Connection processing finished...... ");
        }
        catch (Exception e) {

            LOGGER.info("Connection processing failed..... "+ e.getMessage());
        }finally {

                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) { }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) { }
                }
                if( socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) { }
                }

        }
    }

    }

