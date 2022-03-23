package com.caro.exceptions;

public class UnreadableException extends Exception{
    public UnreadableException() {
    }

    public UnreadableException(String message) {
        super(message);
    }
}
