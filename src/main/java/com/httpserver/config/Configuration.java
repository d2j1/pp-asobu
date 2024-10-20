package com.httpserver.config;

/**
 * This class represents the configuration settings of the server.
 *
 * <p>It contains properties such as the web route and port number, which are essential for
 * the server's operation. This class provides getter and setter methods to access and
 * modify these properties.</p>
 *
 * <p></p>
 *
 * @author Dhananjay
 * @date Aug 13, 2024
 * @updated Aug 13, 2024
 */
public class Configuration {
    // The web route path for the server
    private String webroute;

    // The port number on which the server will listen
    private int port;

    /**
     * This method returns the web route path.
     *
     * @return the web route path as a String.
     */
    public String getWebroute() {
        return webroute;
    }

    /**
     * This method sets the web route path.
     *
     * @param webroute the web route path to set.
     */
    public void setWebroute(String webroute) {
        this.webroute = webroute;
    }

    /**
     * This method returns the port number.
     *
     * @return the port number as an int.
     */
    public int getPort() {
        return port;
    }

    /**
     * This method sets the port number.
     *
     * @param port the port number to set.
     */
    public void setPort(int port) {
        this.port = port;
    }
}