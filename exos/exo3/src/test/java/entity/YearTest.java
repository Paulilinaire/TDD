package entity;

import org.example.entity.Year;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YearTest {

    @Test
    void testDivisibleBy400(){
        Year year = new Year();
        boolean result = year.isLeap(2024);
        Assertions.assertTrue(result);
    }

    @Test
    void testDivisibleBy4(){
        Year year = new Year();
        boolean result = year.isLeap(2000);
        Assertions.assertTrue(result);
    }

    @Test
    void testNotDivisibleBy100(){
        Year year = new Year();
        boolean result = year.isLeap(2100);
        Assertions.assertFalse(result);
    }

    @Test
    void testDivisibleBy4000(){
        Year year = new Year();
        boolean result = year.isLeap(2024);
        Assertions.assertTrue(result);
    }
}
