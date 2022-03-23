package com.caro.stockExample;

import com.caro.exceptions.InvalidFormatException;
import com.caro.exceptions.ResourceNotFoundException;
import com.caro.loggerExample.LoggerExample;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StockService {
    private final static Logger logger = LogManager.getLogger(LoggerExample.class);
    private static StockExample stock = new StockExample();
    private static String nonExistItem = new String("item999");

    public static void execute() {
        addRandomItems();
        checkContains();
    }


    public static void addRandomItems() {
        try {
            stock.addItem("item2");
            logger.info("item2 added.");
            //stock.addItem("lalala");
        } catch (InvalidFormatException e) {
            logger.error("Please check the invalid format. " + e);
        }
    }

    private static void checkContains() {
        try {
            stock.doesItContainItem("item2");
            logger.debug("Can we find the item? " + stock.doesItContainItem("item2"));
            //stock.doesItContainItem(nonExistItem);
            //logger.debug("Can we find the item? " + stock.doesItContainItem(nonExistItem));
        } catch (
                ResourceNotFoundException ex) {
            logger.error("Could not find item. " + ex);
        }
    }

}
