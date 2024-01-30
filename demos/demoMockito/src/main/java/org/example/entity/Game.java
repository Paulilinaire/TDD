package org.example.entity;

public class Game {

    private Dice dice;

    public Game(Dice dice) {
        this.dice = dice;
    }
    public boolean play() {
        return dice.getValue() % 2 == 0;
    }
}
