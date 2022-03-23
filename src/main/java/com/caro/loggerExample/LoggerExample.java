package com.caro.loggerExample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerExample {
    private final static Logger logger = LogManager.getLogger(LoggerExample.class);

    public static void init() {
        logger.fatal("1 fatal");
        logger.error("2 error");
        logger.warn("3 warn");
        logger.info("4 info");
        logger.debug("5 debug");
        logger.trace("6 trace");
        //logger.all("7 all");
    }
}
