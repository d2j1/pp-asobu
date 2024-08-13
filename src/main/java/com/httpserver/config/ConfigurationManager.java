package com.httpserver.config;


/**
 * This is the configuration manager class. It is used to manage the configurations of the server.
 *
 * <p>This class fetches the configuration from the provided file and it map those configurations to the
 * configuration class. It implements the Singleton design pattern</p>
 *
 * <p></p>
 *
 * @author Dhananjay
 * @date Aug 13, 2024
 * @updated Aug 13, 2024
 */

public class ConfigurationManager {

    private static  ConfigurationManager configurationManager;
    private static Configuration config;

    private ConfigurationManager() {

    }

    /**
     * This method creates the single object of the configuration manager class and returns it.
     * This method implements the singleton pattern.
     * @return the Configuration Manager object.
     */
    public static ConfigurationManager getInstance() {

        if (configurationManager == null) {
            configurationManager = new ConfigurationManager();
                    }

        return configurationManager;
    }

    /**
     * This method is used to load the configuration file from the provided path.
     * @Param String - path of the configuration file.
     * @return void.
     */
    public void loadConfigurationFile(String filePath){

    }

    /**
     * This method gets the configurations from the loaded file and returns it.
     * @return void
     */
    public void getCurrentConfiguration(){

    }

}
