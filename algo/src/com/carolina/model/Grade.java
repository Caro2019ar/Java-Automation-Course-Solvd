package com.carolina.model;

public class Grade implements Comparable {
    private String name;
    private double value;

    public Grade(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
