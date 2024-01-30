package org.example.entity;

import lombok.Data;

@Data
public class HangmanGame {

    private RandomWordGenerator randomWordGenerator;
    private String wordToGuess;
    private StringBuilder mask;

    public HangmanGame(RandomWordGenerator randomWordGenerator) {
        this.randomWordGenerator = randomWordGenerator;
        this.wordToGuess = randomWordGenerator.generateWords(new String[]{});
        this.mask = new StringBuilder("_".repeat(wordToGuess.length()));
    }


    public String generateMask() {
        return mask.toString();
    }

    public boolean isCharInWord(char guess) {
        boolean isCharInWord = wordToGuess.indexOf(guess) != -1;

        if (isCharInWord) {
            updateMask(guess);
        }

        return isCharInWord;
    }

    private void updateMask(char guess) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                mask.setCharAt(i, guess);
            }
        }

    }

    public boolean isPlayerWin() {
        return !mask.toString().contains("_");
    }
}

