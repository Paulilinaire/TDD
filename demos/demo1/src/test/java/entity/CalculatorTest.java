package entity;

import org.example.entity.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testAddition(){
        // Arrange : déclarer l'objet dans laquelle se trouve la méthode que l'on veut tester
        Calculator calculator = new Calculator();

        // Act : utiliser la méthode que l'on veut tester
        double result = calculator.addition(10, 45);

        // Assert : assertion fourni par le framework, là on veut tester l'égalité
        Assertions.assertEquals(55, result);
    }

    @Test
    void testDivision1(){
        Calculator calculator = new Calculator();

        double result = calculator.division(10, 2);

        Assertions.assertEquals(5, result);
    }

    @Test
    void testDivision2(){
        Calculator calculator = new Calculator();

        // Act and Assert
        Assertions.assertThrowsExactly(RuntimeException.class, () -> { // on veut que ça soit la RuntimeException précisément qui soit tester
            // Act
            calculator.division(10,0);
        });
    }



}
