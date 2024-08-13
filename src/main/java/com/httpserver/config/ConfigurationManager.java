package com.httpserver.config;

/**
 * This is the configuration manager class. It is used to manage the configurations of the server.
 *
 * <p>This class fetches the configuration from the provided file and maps those configurations to the
 * configuration class. It implements the Singleton design pattern.</p>
 *
 * <p></p>
 *
 * @author Dhananjay
 * @date Aug 13, 2024
 * @updated Aug 13, 2024
 */
public class ConfigurationManager {

    // Singleton instance of ConfigurationManager
    private static ConfigurationManager configurationManager;

    // Instance of Configuration containing server settings
    private static Configuration config;

    // Private constructor to prevent instantiation
    private ConfigurationManager() {
    }

    /**
     * This method creates the single object of the ConfigurationManager class and returns it.
     * This method implements the singleton pattern.
     *
     * @return the ConfigurationManager object.
     */
    public static ConfigurationManager getInstance() {

        if (configurationManager == null) {
            configurationManager = new ConfigurationManager();
        }

        return configurationManager;
    }

    /**
     * This method is used to load the configuration file from the provided path.
     *
     * @param filePath the path of the configuration file.
     */
    public void loadConfigurationFile(String filePath) {
        // Implementation to load configuration will go here
    }

    /**
     * This method gets the configurations from the loaded file and returns it.
     *
     * @return the current Configuration object.
     */
    public void getCurrentConfiguration() {
        // Implementation to return current configuration will go here
    }
}