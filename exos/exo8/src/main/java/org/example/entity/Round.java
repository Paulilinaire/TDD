package org.example.entity;

import lombok.Data;

@Data
public class Round {

    private static final int MAX_ROUND = 10;

    private int currentRound;

    private int lastRound;

    private BowlingGame bowlingGame;

    public boolean StrikeAtLastRound() {
        boolean play = true;
        if (currentRound == lastRound) {
            if (bowlingGame.isStrike()) {
                bowlingGame.roll(0); // Bonus throw
            }
            bowlingGame.setThrowsCount(1); // Standard throws in the last round
        } else {
            bowlingGame.setThrowsCount(2); // Standard throws in the other round
        }
        return play;
    }



}
