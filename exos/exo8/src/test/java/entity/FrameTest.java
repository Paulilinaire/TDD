package entity;

import org.example.entity.Frame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FrameTest {


    private Frame frame;

    @BeforeEach
    void setUp() {
        frame = new Frame();
    }



    @Test
    void gutterTest(){
        for (int i = 0; i < 20; i++){
            frame.roll(0);
        }
        Assertions.assertEquals(0, frame.score());
    }

    @Test
    void strikeTest() {
        for (int i = 0; i < 20; i++) {
            frame.roll(1);
        }
        Assertions.assertEquals(20, frame.score());
    }

    @Test
    void firstThrowInSeriesShouldIncreaseScore() {
        frame.roll(4); // Assume 4 pins knocked down in the first throw
        Assertions.assertEquals(4, frame.score());
    }

    @Test
    void secondThrowInSeriesShouldIncreaseScore() {
        frame.roll(3);
        frame.roll(5);
        Assertions.assertEquals(8, frame.keepingScoreRound());
    }

    @Test
    void cannotRollMoreThanTwiceInStandardSeries() {
        frame.roll(3);
        frame.roll(4);
        frame.roll(5);

        Assertions.assertEquals(7, frame.score());
        // score = 7 beacause it counts the 1st and 2nd throw and not the third
    }


}
