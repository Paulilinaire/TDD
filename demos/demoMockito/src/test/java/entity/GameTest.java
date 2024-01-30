package entity;

import org.example.entity.Dice;
import org.example.entity.Game;
import org.example.entity.RealDice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameTest {

    private Game game;
    @Mock
    private Dice dice;

    @Test
    void testPlayMethodWinResult(){
        game = new Game(dice);

        Mockito.when(dice.getValue()).thenReturn(4);
        Assertions.assertTrue(game.play());
    }

    @Test
    void testPlayMethodLoseResult(){
        game = new Game(dice);
        Assertions.assertFalse(game.play());
    }
}
