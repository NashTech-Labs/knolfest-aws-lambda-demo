package edu.knoldus.utils;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.Optional;

public class ConfigReader {

    private final static Config base = ConfigFactory.load();
    private final static String environment = System.getenv("ENVIRONMENT") == null ? "dev" : System.getenv("ENVIRONMENT");
    private Config config;

    private ConfigReader(String setting) {
        config = base.getConfig(setting);
        if (config.hasPath(environment)) {
            config = config.getConfig(environment).withFallback(config).withFallback(config);
        }
    }

    public static ConfigReader getConfigReader(String setting) {
        return new ConfigReader(setting);
    }

    public String getSenderEmail() {
        Optional<String> senderEmail = Optional.ofNullable(System.getenv("email"));
        return senderEmail.orElse("");
    }

    public String getSenderEmailPassword() {
        Optional<String> senderEmailPassword = Optional.ofNullable(System.getenv("password"));
        return senderEmailPassword.orElse("");
    }

    public String getPort() {
        return config.getString("port");
    }

    public String getHostName() {
        return config.getString("host-name");
    }

}
