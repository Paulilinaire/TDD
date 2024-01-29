package org.example.entity;

public class Calculator {

    public double addition(double a, double b) {
        return a + b;
    }

    public double division(double a, double b) {
        if(b!=0)
            return a/b;
        else
            throw  new RuntimeException("B must be not equal to 0");
    }


}
