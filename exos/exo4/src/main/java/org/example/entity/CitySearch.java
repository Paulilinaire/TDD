package org.example.entity;

import lombok.Setter;
import org.example.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Setter
public class CitySearch {

    private List<String> cities = new ArrayList<>();

    public List<String> searchCities(String searchWord) {
        if (searchWord.length() < 2) {
            throw new NotFoundException();
        } else {
            List<String> foundCities = new ArrayList<>();
            for (String city : cities) {
                if (city.toLowerCase().contains(searchWord.toLowerCase())) {
                    foundCities.add(city);
                }
            }
            return foundCities;
        }

    }
}
