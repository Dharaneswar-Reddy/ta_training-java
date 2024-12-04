package com.epam.training.virupakshi_dharaneswar_reddy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    private static Logger logger = LoggerFactory.getLogger(ConfigReader.class);

    static {
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fis);
            logger.info("Config file loaded successfully from 'src/main/resources/config.properties'");
        } catch (IOException e) {
            logger.error("Error occurred while loading config file: {}", e.getMessage());
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            logger.info("Retrieved property '{}' with value: {}", key, value);
        } else {
            logger.warn("Property '{}' not found in the config file", key);
        }
        return value;
    }
}
