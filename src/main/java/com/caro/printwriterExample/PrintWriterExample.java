package com.caro.printwriterExample;


import com.caro.loggerExample.LoggerExample;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {
    private final static Logger logger = LogManager.getLogger(LoggerExample.class);

    public static void print() throws IOException {
        FileWriter file = new FileWriter("file.txt");
        PrintWriter printWriter = new PrintWriter(file);
        logger.debug("Debug from logger. File: " + file);

        printWriter.println("line 1: Test");
        printWriter.println("Encoding: " + file.getEncoding());
        printWriter.close();
    }
}
