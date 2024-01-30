package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.exception.QualityException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Product {

    private List<String> products = new ArrayList<>();

    private String name;

    private int expirationDate;

    private int sellIn;

    private int quality;

    public Product() {
    }

    public Product(String name, int expirationDate, int sellIn, int quality) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.sellIn = sellIn;
        this.quality = quality;
    }


    public void updateQuality() {
        if (expirationDate <= 0) {
            // Une fois la date de péremption est à zéro, la qualité se dégrade deux fois plus vite.
            quality -= 2;
        } else {
            quality--;
        }

        // La qualité d'un article n'est jamais négative.
        if (quality < 0 || quality > 50) {
            quality = (quality < 0) ? 0 : 50;
            throw new QualityException();
        }
    }

}
