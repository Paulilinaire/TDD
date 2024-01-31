package org.example.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BowlingGame {

    private static final int MAX_THROWS = 2;

    private PinGenerator pinGenerator;

    private int score = 0;
    private int throwsCount = 0;
    private List<Integer> throwsResults = new ArrayList<>();
    private boolean includeNextRollInScore = false;

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
        int totalScore = score;

        if (isSpare() && includeNextRollInScore) {
            // Si le dernier lancer était un spare, ajoute le résultat du prochain lancer au score
            totalScore += throwsResults.get(throwsResults.size() - 1);
            // Réinitialise l'indicateur
            includeNextRollInScore = false;
        }

        return totalScore;
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
    public boolean canRollAgain() {
        return throwsCount < MAX_THROWS || (throwsCount == MAX_THROWS && isSpare());

    }
    private boolean isSpare() {
        return throwsResults.size() >= 2 &&
                throwsResults.get(throwsResults.size() - 1) + throwsResults.get(throwsResults.size() - 2) == 10;
    }
}
