package test;

import base.*;
import function.Exponential;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExponentialTest {
    @Test
    public void init() {
        Constant n = new SimpleConstant(3);
        Exponential exponential = new Exponential(new Constant[]{new SimpleConstant(0)}, false);
        exponential.init(new Constant[]{n});
        String stringRep = exponential.stringRep();
        String expectedStringRep = "3.0^x";
        assertEquals(expectedStringRep, stringRep);
    }

    @Test
    public void solve() {
        Constant n = new SimpleConstant(3);
        Exponential exponential = new Exponential(new Constant[]{n}, false);
        double value = exponential.solve(new Variable[]{new SimpleVariable('x', 4)});
        double expectedValue = 81;
        assertEquals(expectedValue, value, 0);
    }

    @Test
    public void derivative() {
        Constant n = new SimpleConstant(3);
        Exponential exponential = new Exponential(new Constant[]{n}, false);
        String derivative = exponential.derivative().stringRep();
        String expectedDerivative = "+" + Math.log(3) + "*3.0^x";
        assertEquals(expectedDerivative, derivative);
    }

    @Test
    public void antiDerivative() {
        Constant n = new SimpleConstant(3);
        Exponential exponential = new Exponential(new Constant[]{n}, false);
        String antiDerivative = exponential.antiDerivative().stringRep();
        String expectedAntiDerivative = "+" + 1 / Math.log(3) + "*3.0^x";
        assertEquals(expectedAntiDerivative, antiDerivative);
    }

}