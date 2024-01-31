package entity;

import org.example.entity.HangmanGame;
import org.example.entity.WordGenerator;
import org.example.exception.LoseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HangmanGameTest {

    @Mock
    private WordGenerator wordGenerator;
    private HangmanGame hangman;

    @BeforeEach
    void setUp() {
        Mockito.when(wordGenerator.generateWords()).thenReturn("google");
        hangman = new HangmanGame(wordGenerator);
        hangman.makeMask();
    }

    @Test
    void testConvertWordToMask() {
        Assertions.assertEquals("______", hangman.getMask());
    }
    @Test
    void testTryCharWithCorrectChar() {
        boolean result = hangman.tryChar('g');
        Assertions.assertTrue(result);
    }
    @Test
    void testTryCharWithWrongChar() {
        boolean result = hangman.tryChar('t');
        Assertions.assertFalse(result);
    }

    @Test
    void testTryCharWithCorrectCharShouldNotUpdateTryValue() {
        int tryNumber = hangman.getTryNumber();
        hangman.tryChar('g');
        Assertions.assertEquals(tryNumber, hangman.getTryNumber());
    }

    @Test
    void testTryCharWithWrongCharShouldNotDecreaseTryValue() {
        int tryNumber = hangman.getTryNumber();
        hangman.tryChar('a');
        Assertions.assertEquals(tryNumber-1, hangman.getTryNumber());
    }

    @Test
    void testTryCharWithCorrectCharShouldUpdateMask() {
        hangman.tryChar('g');
        Assertions.assertEquals("g__g__", hangman.getMask());
    }

    @Test
    void testTryCharWithWrongCharShouldNotUpdateMask() {
        hangman.tryChar('g');
        hangman.tryChar('a');
        Assertions.assertEquals("g__g__", hangman.getMask());
    }

    @Test
    void testWinWithCheckVictoryWithCorrectMask() {
        //Arrange
        hangman.tryChar('g');
        hangman.tryChar('o');
        hangman.tryChar('l');
        hangman.tryChar('e');

        //Act
        boolean res = hangman.checkVictory();

        // Assert
        Assertions.assertTrue(res);
    }
    @Test
    void testVictoryWhenCheckVictoryWithWrongMask() {

        hangman.tryChar('g');


        boolean res = hangman.checkVictory();

        Assertions.assertFalse(res);
    }

    @Test
    void testTryCharRaiseExceptionWhenTryNumberIs0() {

        //Arrange
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');

        //Act
        Assertions.assertThrowsExactly(LoseException.class, () -> {
            hangman.tryChar('c');
        });
    }

    @Test
    void testCheckVictoryRaiseExceptionWhenTryNumberIs0() {

        //Arrange
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');
        hangman.tryChar('c');

        //Act
        Assertions.assertThrowsExactly(LoseException.class, () -> {
            hangman.checkVictory();
        });
    }

}
