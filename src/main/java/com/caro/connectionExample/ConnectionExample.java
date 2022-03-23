package com.caro.connectionExample;

import com.caro.exceptions.UnreadableException;
import com.caro.loggerExample.LoggerExample;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionExample implements AutoCloseable{
    private final static Logger logger = LogManager.getLogger(LoggerExample.class);
    public ConnectionExample() {
    }
    public void readData() throws UnreadableException {
        logger.info("Start to read database...");
        throw new UnreadableException();
    }
    public void connectToDB(){
        logger.info("Connecting to DB");
    }

    @Override
    public void close() {
        logger.info("Closing DB");
    }


}
