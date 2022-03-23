package com.caro.connectionExample;

import com.caro.exceptions.UnreadableException;
import com.caro.loggerExample.LoggerExample;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionTest {
    private final static Logger logger = LogManager.getLogger(LoggerExample.class);

    public static void main(String[] args) {
        try (ConnectionExample conn = new ConnectionExample()) {
            conn.readData();
        } catch (UnreadableException ex) {
            logger.error(ex);
        }
    }
}