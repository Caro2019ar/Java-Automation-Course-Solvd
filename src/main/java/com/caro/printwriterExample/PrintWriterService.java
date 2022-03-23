package com.caro.printwriterExample;

import com.caro.loggerExample.LoggerExample;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class PrintWriterService {
    private final static Logger logger = LogManager.getLogger(LoggerExample.class);
    public static void service()  {
        try {
            PrintWriterExample.print();
        } catch (IOException e) {
            logger.error(e);
        }
    }
}
