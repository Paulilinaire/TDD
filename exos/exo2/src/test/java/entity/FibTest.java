package entity;

import org.example.entity.Fib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FibTest {

    private List<Integer> initFib(int range) {
        Fib fib = new Fib(range);
        return fib.getFibSeries();
    }

    // Lors du déclenchement de la fonction getFibSeries() avec un Range de 1
    // Le résultat n’est pas vide
    @Test
    void resultNotEmpty() {
        List<Integer> result = initFib(1);

        Assertions.assertFalse(result.isEmpty());
    }


    // Le résultat correspond à une liste qui contient {0}
    @Test
    void resultEqualsZero() {
        List<Integer> result = initFib(1);
        List<Integer> expected = List.of(0);

        Assertions.assertEquals(expected, result);
    }


    // Lors du déclanchement de la fonction getFibSeries() avec un Range de 6
    // Le résultat contient le chiffre 3
    @Test
    void resultContainsThree() {
        List<Integer> result = initFib(6);

        Assertions.assertTrue(result.contains(3));
    }


    // Le résultat contient 6 éléments
    @Test
    void resultContainsSixElements() {
        List<Integer> result = initFib(6);

        Assertions.assertEquals(6, result.size());
    }


    // Le résultat n’a pas le chiffre 4 en son sein
    @Test
    void resultNotContainsFour() {
        List<Integer> result = initFib(6);

        Assertions.assertFalse(result.contains(4));
    }


    // Le résultat correspond à une liste qui contient {0, 1, 1, 2, 3, 5}
    @Test
    void givenListOfIntegers() {
        List<Integer> result = initFib(6);

        Assertions.assertEquals(result.containsAll(Arrays.asList(0, 1, 1, 2, 3, 5)), result);
    }


    // Le résultat est trié de façon ascendance
    @Test
    void resultSortedByAscOrder() {
        List<Integer> result = initFib(6);

        Assertions.assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5), result);
    }
}
