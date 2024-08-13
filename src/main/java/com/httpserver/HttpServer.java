package com.httpserver;

import com.httpserver.config.Configuration;
import com.httpserver.config.ConfigurationManager;

public class HttpServer {

    public static void main(String[] args) {
        System.out.println("Server Starting...");
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        System.out.println(conf.getPort());
        System.out.println(conf.getWebroute());

    }

}
