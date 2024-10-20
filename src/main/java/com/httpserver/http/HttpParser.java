package com.httpserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;
/**
 * Class name - HttpParser
 *
 * <p>This is HttpParser class.  </p>
 *
 * @author Dhananjay
 * @date 8/27/2024
 * @updated 8/27/2024
 */

public class HttpParser {

    private final static Logger LOGGER = Logger.getLogger(HttpParser.class.getName());

    private static final int SP = 0x20; // space - decimal - 32
    private static final int CR = 0x0D; // Carriage Return - decimal - 13
    private static final int LF = 0x0A; // Line Feed - decimal - 10


    public HttpRequest parseHttpRequest(InputStream inputStream) {

        HttpRequest httpRequest = new HttpRequest();

        InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);
        try {
            parseRequestLine(isr, httpRequest);
        } catch (IOException | HttpParsingException e) {
            e.printStackTrace();
        }
        parseHeaders(isr, httpRequest);
        parseBody(isr, httpRequest);

        return httpRequest;
    }

    private void parseRequestLine(InputStreamReader isr, HttpRequest httpRequest) throws IOException, HttpParsingException {

        StringBuilder processingDataBuffer = new StringBuilder();
        boolean methodParsed = false;
        boolean requestTargetParsed = false;
        int _byte;

        while((_byte = isr.read()) >= 0){

            if( _byte == CR){
                _byte = isr.read();

                if( _byte == LF){


                    LOGGER.info("Request Line version to Process : " + processingDataBuffer.toString() );

                    if(!methodParsed || !requestTargetParsed){
                        throw new HttpParsingException(HttpStatusCode.CLIENT_ERROR_400_BAD_REQUEST);
                    }

                    return;
                }
            }

            if(_byte == SP){

                if(!methodParsed){

                LOGGER.info("Request Line Method to Process : " + processingDataBuffer.toString() );
                httpRequest.setMethod(processingDataBuffer.toString());
                    methodParsed = true;
                } else if (!requestTargetParsed) {
                    LOGGER.info("Request Line request target to Process : " + processingDataBuffer.toString() );
                    requestTargetParsed = true;
                }else {
                    throw  new HttpParsingException(HttpStatusCode.CLIENT_ERROR_400_BAD_REQUEST);
                }
                processingDataBuffer.delete(0, processingDataBuffer.length());

            }else{
                processingDataBuffer.append((char) _byte);

                if(!methodParsed){
                    if( processingDataBuffer.length() > HttpMethod.MAX_LENGTH){
                        throw new HttpParsingException(HttpStatusCode.SERVER_ERROR_501_METHOD_NOT_IMPLEMENTED);
                    }
                }
            }
        }



    }

    private void parseBody(InputStreamReader isr, HttpRequest httpRequest) {
    }

    private void parseHeaders(InputStreamReader isr, HttpRequest httpRequest) {
    }



}
