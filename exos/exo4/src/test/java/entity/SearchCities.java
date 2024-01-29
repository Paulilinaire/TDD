package entity;


import org.example.entity.CitySearch;
import org.example.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CitySearchTest {

    @Test
    void searchCitiesTestLessThan2Char() {
        CitySearch citySearch = new CitySearch();
        Assertions.assertThrows(NotFoundException.class, () -> {
            citySearch.searchCities("A");
        });
    }

    @Test
    void searchCitiesTestEqualOrMoreThan2Char() {
        CitySearch citySearch = new CitySearch();
        List<String> result = citySearch.searchCities("Va");
        Assertions.assertEquals(Arrays.asList("Valence", "Vancouver"), result);
    }

    @Test
    void searchCitiesTestIgnoreCase(){
        CitySearch citySearch = new CitySearch();
        List<String> result = Collections.singletonList(citySearch.searchCities("Paris").toString().toLowerCase().toUpperCase());
        Assertions.assertEquals("Paris"), result;
    }

}


