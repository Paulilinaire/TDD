package org.example.entity;

import lombok.Data;

import java.util.Random;

@Data
public class RandomWordGenerator implements WordGenerator {

    private Random random;

    public RandomWordGenerator() {
        random = new Random();
    }

    @Override
    public String generateWords(String[] words) {
        int index = random.nextInt(words.length);
        return words[index];
    }
}
