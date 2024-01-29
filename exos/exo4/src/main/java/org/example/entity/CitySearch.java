package org.example.entity;

import org.example.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CitySearch {

    private List<String> cities = Arrays.asList(
            "Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver",
            "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok",
            "Hong Kong", "Dubaï", "Rome", "Istanbul");
    public List<String> searchCities(String searchWord){
        if (searchWord.length() < 2) {
            throw new NotFoundException();
        }
        List<String> foundCities = new ArrayList<>();
        for (String city : cities) {
            if (city.toLowerCase().contains(searchWord.toLowerCase())) {
                foundCities.add(city);
            }
        }
        return foundCities;
    }
}
