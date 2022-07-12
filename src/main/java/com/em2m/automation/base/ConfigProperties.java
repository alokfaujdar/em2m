package com.em2m.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class ConfigProperties {

    public static final Properties EM2M = loadGlobalVariables();

    public static final Properties loadGlobalVariables() {
        Properties props;
        props = loadLocatorProps("src/main/resources/Configuration.properties");
        return props;
    }

    public static final Properties XPATH = loadLocator();

    public static final Properties loadLocator() {
        Properties props;
        props = loadLocatorProps("src/main/resources/locators.properties");
        return props;
    }

    public static final Properties loadLocatorProps(String file) {
        Properties props = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            if (input == null) {
                return null;
            }
            props.load(input);
            return props;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
