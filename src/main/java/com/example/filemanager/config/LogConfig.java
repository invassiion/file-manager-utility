package com.example.filemanager.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class LogConfig {
    private static final Logger logger = LogManager.getLogger(LogConfig.class);

    public static void configure() {
        Configurator.initialize("Log4j2", "src/main/resources/log4j2.xml");
        logger.info("Log4j2 configuration initialized.");
    }
}
