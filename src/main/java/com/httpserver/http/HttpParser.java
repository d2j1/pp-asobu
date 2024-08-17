package com.httpserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class HttpParser {

    private final static Logger LOGGER = Logger.getLogger(HttpParser.class.getName());

    private static final int sp = 0x20; // space - decimal - 32
    private static final int CR = 0x0D; // Carriage Return - decimal - 13
    private static final int LF = 0x0A; // Line Feed - decimal - 10


    public HttpRequest parseHttpRequest(InputStream inputStream){

        HttpRequest httpRequest = new HttpRequest();

        InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);
        parseRequestLine(isr, httpRequest);
        parseHeaders(isr, httpRequest);
        parseBody(isr, httpRequest);

        return httpRequest;
    }

    private void parseRequestLine(InputStreamReader isr, HttpRequest httpRequest) throws IOException {

        int _byte;

        while((_byte = isr.read()) >= 0){

            if( _byte == CR){
                _byte = isr.read();

                if( _byte == LF){
                    return;
                }
            }
        }

    }

    private void parseBody(InputStreamReader isr, HttpRequest httpRequest) {
    }

    private void parseHeaders(InputStreamReader isr, HttpRequest httpRequest) {
    }



}
