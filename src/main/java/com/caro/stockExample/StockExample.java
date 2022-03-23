package com.caro.stockExample;

import com.caro.exceptions.InvalidFormatException;
import com.caro.exceptions.ResourceNotFoundException;

import java.util.ArrayList;


public class StockExample {
    private static ArrayList<String> fakeDB = new ArrayList<>();

    public StockExample() {
    }

    public void addItem(String item) throws InvalidFormatException {
        if(!item.toLowerCase().contains("item")){
            throw new InvalidFormatException();
        }
        fakeDB.add(item);
    }

    public Boolean doesItContainItem(String item) throws ResourceNotFoundException {
        if (!fakeDB.contains(item)) {
            throw new ResourceNotFoundException();
        }
        return fakeDB.contains(item);
    }

    public ArrayList<String> getFakeDB() {
        return fakeDB;
    }


}
