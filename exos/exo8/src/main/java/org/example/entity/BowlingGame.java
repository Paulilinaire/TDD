package org.example.entity;

import lombok.Data;

@Data
public class BowlingGame {

    private static final int MAX_THROWS = 2;

    private PinGenerator pinGenerator;

    private int score = 0;
    private int throwsCount = 0;

    public BowlingGame(PinGenerator pinGenerator) {
        this.pinGenerator = pinGenerator;
    }

    public void roll(int pins) {
        if (throwsCount < MAX_THROWS) {
            score += pins; // In each try, we knock down a pin and it's added to the score
            throwsCount++;
        }
    }


    public int score() {
        return score;
    }

    public boolean isStrike() {
        return score == 10;
    }

    public int keepingScoreRound() {
        if (throwsCount % 2 == 0) {
            return score;
        } else {
            return score + lastThrowScore();
        }
    }

    private int lastThrowScore() {
        // We implement logic to retrieve the score of the last throw
        // In this example, we assume each throw scores the same as the number of pins knocked down
        return score - (throwsCount % 2 == 0 ? 0 : 1);
    }
}
