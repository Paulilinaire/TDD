package org.example.entity;

import lombok.Data;

import java.util.Random;

@Data
public class RealDice {

    private Random random;

    public RealDice() {
        random = new Random();
    }
    public  int getValue() {
        return random.nextInt(1,7);
    }

}
