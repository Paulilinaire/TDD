package entity;

import org.example.entity.Tools;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ToolsTest {

    @Test
    void testIfNumber(){
        Tools tools = new Tools();
        boolean res = tools.isEven(2);
        Assertions.assertTrue(res);
    }

    @Test
    void testIfOdd(){
        Tools tools = new Tools();
        boolean res = tools.isEven(3);
        Assertions.assertFalse(res);
    }
}
