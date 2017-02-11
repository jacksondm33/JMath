package test;

import base.*;
import function.Power;
import org.junit.Test;
import static org.junit.Assert.*;

public class PowerTest {
    @Test
    public void init() {
        Constant n = new SimpleConstant(3);
        Power power = new Power(new Constant[]{new SimpleConstant(0)}, false);
        power.init(new Constant[]{n});
        String stringRep = power.stringRep();
        String expectedStringRep = "x^3.0";
        assertEquals(expectedStringRep, stringRep);
    }

    @Test
    public void solve() {
        Constant n = new SimpleConstant(3);
        Power power = new Power(new Constant[]{n}, false);
        double value = power.solve(new Variable[]{new SimpleVariable('x', 4)});
        double expectedValue = 64;
        assertEquals(expectedValue, value, 0);
    }

    @Test
    public void derivative() {
        Constant n = new SimpleConstant(3);
        Power power = new Power(new Constant[]{n}, false);
        String derivative = power.derivative().stringRep();
        String expectedDerivative = "+3.0*x^2.0";
        assertEquals(expectedDerivative, derivative);
    }

    @Test
    public void antiDerivative() {
        Constant n = new SimpleConstant(3);
        Power power = new Power(new Constant[]{n}, false);
        String antiDerivative = power.antiDerivative().stringRep();
        String expectedAntiDerivative = "+0.25*x^4.0";
        assertEquals(expectedAntiDerivative, antiDerivative);
    }

}