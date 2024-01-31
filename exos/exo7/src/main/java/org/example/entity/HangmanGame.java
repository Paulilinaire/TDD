package org.example.entity;

public class HangmanGame {

    private WordGenerator wordGenerator;

    private String winnerWord;
    private String mask;

    private int tryNumber;

    public  String getMask() {
        return mask;
    }

    public int getTryNumber() {return tryNumber;}

    public HangmanGame(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
        tryNumber = 10;

    }

    public boolean tryChar(char inputChar) {
        boolean found = false;
        StringBuilder nextMaskBuilder = new StringBuilder();
        for(int i=0; i < winnerWord.length(); i++) {
            if(winnerWord.charAt(i) == inputChar) {
                nextMaskBuilder.append(inputChar);
                found = true;
            }
            else {
                nextMaskBuilder.append(this.mask.charAt(i));
            }
        }
        if (found) {
            this.mask = nextMaskBuilder.toString();
        }else {
            tryNumber--;
        }
        return found;
    }

    public void makeMask() {
        this.winnerWord = wordGenerator.generateWords();
        StringBuilder builder = new StringBuilder();
        for(int i=0; i < this.winnerWord.length(); i++) {
            builder.append("_");
        }
        this.mask = builder.toString();
    }

    public boolean checkVictory() {
        return winnerWord.equals(mask);
    }
}
