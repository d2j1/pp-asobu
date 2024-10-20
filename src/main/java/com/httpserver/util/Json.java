package com.httpserver.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

/**
 * This utility class provides methods for handling JSON data using the Jackson library.
 *
 * <p>The class offers functionalities to parse JSON strings into JsonNode objects, convert JSON
 * to and from Java objects, and generate JSON strings. It uses a singleton ObjectMapper
 * for all operations.</p>
 *
 * <p></p>
 *
 * @author Dhananjay
 * @date Aug 13, 2024
 * @updated Aug 13, 2024
 */
public class Json {

    // Singleton ObjectMapper instance
    private static ObjectMapper objectMapper = defaultObjMapper();

    /**
     * This method initializes the ObjectMapper instance with specific configurations.
     *
     * @return the configured ObjectMapper object.
     */
    private static ObjectMapper defaultObjMapper() {
        ObjectMapper objMapper = new ObjectMapper();
        // Configure ObjectMapper to ignore unknown properties during deserialization
        objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objMapper;
    }

    /**
     * This method parses a JSON string and converts it into a JsonNode object.
     *
     * @param json the JSON string to be parsed.
     * @return the parsed JsonNode object.
     * @throws JsonProcessingException if an error occurs during parsing.
     */
    public static JsonNode parse(String json) throws JsonProcessingException {
        return objectMapper.readTree(json);
    }

    /**
     * This method converts a JsonNode object into a specified Java object.
     *
     * @param <A> the type of the Java object.
     * @param json the JsonNode object to be converted.
     * @param clazzz the class of the Java object.
     * @return the Java object of type A.
     * @throws JsonProcessingException if an error occurs during conversion.
     */
    public static <A> A fromJson(JsonNode json, Class<A> clazzz) throws JsonProcessingException {
        return objectMapper.treeToValue(json, clazzz);
    }

    /**
     * This method converts a Java object into a JsonNode object.
     *
     * @param obj the Java object to be converted.
     * @return the resulting JsonNode object.
     * @throws JsonProcessingException if an error occurs during conversion.
     */
    public static JsonNode toJson(Object obj) throws JsonProcessingException {
        return objectMapper.valueToTree(obj);
    }

    /**
     * This method converts a JsonNode object into a JSON string.
     *
     * @param node the JsonNode object to be converted.
     * @return the JSON string representation of the node.
     * @throws JsonProcessingException if an error occurs during conversion.
     */
    public static String stringify(JsonNode node) throws JsonProcessingException {
        return generateJson(node, false);
    }

    /**
     * This method converts a JsonNode object into a pretty-printed JSON string.
     *
     * @param node the JsonNode object to be converted.
     * @return the pretty-printed JSON string representation of the node.
     * @throws JsonProcessingException if an error occurs during conversion.
     */
    public static String stringifyPretty(JsonNode node) throws JsonProcessingException {
        return generateJson(node, true);
    }

    /**
     * This method generates a JSON string from a given object, with an option for pretty-printing.
     *
     * @param obj the object to be converted into JSON.
     * @param pretty a boolean flag indicating whether to pretty-print the JSON string.
     * @return the generated JSON string.
     * @throws JsonProcessingException if an error occurs during generation.
     */
    private static String generateJson(Object obj, boolean pretty) throws JsonProcessingException {
        ObjectWriter ow = objectMapper.writer();

        // Enable pretty-printing if requested
        if (pretty) {
            ow = ow.with(SerializationFeature.INDENT_OUTPUT);
        }
        return ow.writeValueAsString(obj);
    }
}