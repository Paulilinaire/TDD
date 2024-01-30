package entity;


import org.example.entity.CitySearch;
import org.example.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CitySearchTest {

    private CitySearch citySearch;

    @BeforeEach
    void setUp(){
        citySearch = new CitySearch();
        citySearch.setCities(Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver",
                "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok",
                "Hong Kong", "Dubaï", "Rome", "Istanbul"));
    }


    // 1. Si le texte de la recherche contient moins de 2 caractères,
    // aucun résultat ne devrait être renvoyé ou ***Une exception est levée de type NotFoundException***.
    @Test
    void searchCitiesTestLessThan2CharThatRaiseException() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            citySearch.searchCities("a");
        });
    }

    @Test
    void searchCitiesTestLessThan2CharThatDoesNotRaiseException() {
        Assertions.assertDoesNotThrow(() -> citySearch.searchCities("az"));
    }


    // 2. Si le texte de recherche est égal ou supérieur à 2 caractères, il doit renvoyer tous les noms de ville commençant par le texte de recherche exact.
    //    Par exemple, pour le texte de recherche "Va", la fonction doit renvoyer Valence et Vancouver
    @Test
    void searchCitiesTestShouldReturnCitiesStartedWithWordsSearch() {
        List<String> result = citySearch.searchCities("Va");
        Assertions.assertEquals(Arrays.asList("Valence", "Vancouver"), result);
    }


    // 3. La fonctionnalité de recherche doit être insensible à la casse
    @Test
    void searchCitiesTestIgnoreCase(){
        List<String> result = citySearch.searchCities("vA");
        Assertions.assertEquals(Arrays.asList("Valence", "Vancouver"), result);

    }

    // 4. La fonctionnalité de recherche devrait également fonctionner lorsque le texte de recherche n'est qu'une partie d'un nom de ville
    //   Par exemple "ape" devrait renvoyer la ville "Budapest"
    @Test
    void searchCitiesTestShouldReturnContainsWordSearch(){
        List<String> result = citySearch.searchCities("ape");
        Assertions.assertEquals(List.of("Budapest"), result);
    }

    // 5. Si le texte de recherche est un « * » (astérisque), il doit renvoyer tous les noms de ville.
    @Test
    void testSearchCityShouldReturnAllCitiesWhenWordSearchIsAsterisk() {
        List<String> result = citySearch.searchCities("*");
        Assertions.assertEquals(List.of("Paris", "Budapest", "Rotterdam", "Valence", "Vancouver"), result);
    }

}


