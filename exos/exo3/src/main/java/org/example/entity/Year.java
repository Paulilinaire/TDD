package org.example.entity;

public class Year {
    public boolean isLeap(int year) {
        return year % 400 == 0 || year % 100 != 0 || year % 4000 == 0;
    }

}
