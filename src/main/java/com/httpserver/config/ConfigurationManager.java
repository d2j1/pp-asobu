package com.httpserver.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.httpserver.util.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
     * This method is used to load the configuration file from the provided path and
     * convert the configuration to the Configuration class.
     *
     * @param filePath the path of the configuration file.
     */
    public void loadConfigurationFile(String filePath)  {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new HttpConfigurationException(e);
        }
        StringBuffer sb = new StringBuffer();

        int i =0;

        try {
            while( (  i = fileReader.read()) != -1){
                sb.append((char)i);

            }
        }catch(IOException e){
            throw new HttpConfigurationException(e);
        }


        JsonNode node = null;
        try {
            node = Json.parse(sb.toString());
        } catch (JsonProcessingException e) {
            throw new HttpConfigurationException("Error parsing the configuration file", e);
        }
        try {
            config = Json.fromJson(node , Configuration.class);
        } catch (JsonProcessingException e) {
            throw new HttpConfigurationException("Error parsing the configuration file in converting json to configuration object", e);
        }
    }

    /**
     * This method gets the configurations from the loaded file and returns it.
     *
     * @return the current Configuration object.
     */


    public Configuration getCurrentConfiguration() {

        if( config != null ){
            return config;
        }else {
            throw new HttpConfigurationException("No current configuration set");
        }
    }
}