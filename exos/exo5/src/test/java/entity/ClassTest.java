package entity;

import org.example.entity.Product;
import org.example.exception.QualityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClassTest {

//    Voici les règles de décrémentation :
//         - Une fois la date de péremption est à zéro, la qualité se dégrade deux fois plus vite.
//         - La qualité d'un article n'est jamais négative.
//         - La qualité d'un article n'est jamais supérieure à 50.
//         - La qualité du « brie vieilli » augmente à mesure qu'il vieillit.
//         - Les produits laitiers se dégradent en qualité deux fois plus vite que les produits normaux


    private Product product;

    @BeforeEach
    void setUp(){
        product = new Product();
    }



    @Test
    void testQualityDecrementWhenExpirationDateIsZero(){
        product.setExpirationDate(0);

        product.setQuality(10);

        product.updateQuality();

        Assertions.assertEquals(5, product.getQuality());
    }

    @Test
    void testQualityNeverNegative(){
        product.setQuality(1);

        Assertions.assertTrue(product.getQuality() >= 0);
    }

    @Test
    void testQualityNeverNegativeRaiseException(){
        product.setQuality(-1);

        Assertions.assertThrowsExactly(QualityException.class, () -> {
           product.updateQuality();
        });
    }

    @Test
    void testQualityNeverAbove50(){
        product.setQuality(49);

        Assertions.assertTrue(product.getQuality() <= 50);
    }

    @Test
    void testSettingQualityAbove50ThrowsException() {
        Assertions.assertThrowsExactly(QualityException.class, () -> {
            product.setQuality(51);
            product.updateQuality();
        });
    }


}
