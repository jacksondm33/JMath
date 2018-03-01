package helper;

import org.junit.Test;
import static org.junit.Assert.*;

public class FunctionCreatorTest {

    @Test
    public void create(){
        String function = FunctionCreator.create("5((x+(-5))^3)(2^x)+(-2)").toString();
        // Soon to be: 5((x-5)^3)(2^x)-2
        String expectedFunction = "(5.0)(((x)+(-5.0))^3.0)(2.0^(x))+(-2.0)";
        assertEquals(expectedFunction, function);
    }

}