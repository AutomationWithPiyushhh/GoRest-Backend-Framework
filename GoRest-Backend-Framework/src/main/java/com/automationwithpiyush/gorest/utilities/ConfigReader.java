package com.automationwithpiyush.gorest.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    // Static block to load properties once when the class is loaded
    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.err.println("Configuration file not found or unreadable: " + e.getMessage());
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    /**
     * Retrieves a property value by its key.
     * @param key The key to look up in the properties file.
     * @return The string value of the property.
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            return value;
        } else {
            throw new RuntimeException("Property '" + key + "' not specified in the config.properties file.");
        }
    }
}