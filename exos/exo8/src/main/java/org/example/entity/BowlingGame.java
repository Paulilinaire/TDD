package org.example.entity;

import lombok.Data;

@Data
public class BowlingGame {

    private static final int MAX_THROWS = 2;

    private PinGenerator pinGenerator;

    private int score = 0;
    private int throwsCount = 0;

    public BowlingGame(PinGenerator pinGenerator){
        this.pinGenerator = pinGenerator;

    }

    public void roll(int pins) {
        if (throwsCount < MAX_THROWS) {
        score += pins; // in each try, we hit a pin and it's added to the score
        throwsCount++;
        }
    }

    public int score(){
        return score; // we keep track of the score
    }

    public int keepingScoreRound() {
        if (throwsCount % 2 == 0) {
            // If even number of throws, return the current score
            return score;
        } else {
            // If odd number of throws, return the current score plus the score of the previous throw
            return score + lastThrowScore();
        }
    }

    private int lastThrowScore() {
        // Implement logic to retrieve the score of the last throw
        // In this example, assume each throw scores the same as the number of pins knocked down
        return score - throwsCount % 2;
    }




}
