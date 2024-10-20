package com.httpserver.config;

/**
 * Class name - HttpConfigurationException
 *
 * <p>This is HttpConfigurationException class. It is used to throw the configuration exeption </p>
 *
 * @author Dhananjay
 * @date 8/13/2024
 * @updated 8/13/2024
 */

public class HttpConfigurationException extends RuntimeException{

    
    public HttpConfigurationException() {
    }

    public HttpConfigurationException(String message) {
        super(message);
    }


    public HttpConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }


    public HttpConfigurationException(Throwable cause) {
        super(cause);
    }


}


