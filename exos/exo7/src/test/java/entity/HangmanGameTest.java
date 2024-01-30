package entity;

import org.example.entity.HangmanGame;
import org.example.entity.RandomWordGenerator;
import org.example.entity.WordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class HangmanGameTest {

    @Mock
    private RandomWordGenerator randomWordGenerator;

    private HangmanGame hangmanGame;


    @BeforeEach
    void setup(){
        randomWordGenerator = Mockito.mock(RandomWordGenerator.class);
        Mockito.when(randomWordGenerator.generateWords(any())).thenReturn("tam");
        hangmanGame = new HangmanGame(randomWordGenerator);
    }

    @Test
    void maskTest(){
        String mask = hangmanGame.generateMask();
        Assertions.assertEquals("_______", mask);
    }



    @Test
    void testLetterInWord() {
        Assertions.assertTrue(hangmanGame.isCharInWord('a'));
    }



    @Test
    void playerWinsWhenTIsGuessed() {
        hangmanGame.isCharInWord('t');

        Assertions.assertEquals(hangmanGame.isPlayerWin());
    }

    @Test
    void playerWinsWhenAIsGuessed() {
        hangmanGame.isCharInWord('a');

        Assertions.assertTrue(hangmanGame.isPlayerWin());
    }

    @Test
    void playerWinsWhenMIsGuessed() {
        hangmanGame.isCharInWord('m');

        Assertions.assertTrue(hangmanGame.isPlayerWin());
    }


}