package com.example.emicalculator;

public class Bank {
    private String name;
    private float interestRate;

    public Bank(String name, float interestRate) {
        this.name = name;
        this.interestRate = interestRate;
    }

    public String getName() {
        return name;
    }

    public float getInterestRate() {
        return interestRate;
    }


}
