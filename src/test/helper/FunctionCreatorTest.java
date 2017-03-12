package helper;

import org.junit.Test;

public class FunctionCreatorTest {

    @Test
    public void create(){
        System.out.println("Function: " + FunctionCreator.create("(5)(((x)+(-5))^(3))(2^x)+(-2)"));
    }

}