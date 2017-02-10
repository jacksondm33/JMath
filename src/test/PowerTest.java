package test;

import base.*;
import function.Power;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerTest {
    @Test
    void init() {
        Constant n = new SimpleConstant(3);
        Power power = new Power(new Constant[]{new SimpleConstant(0)}, false);
        power.init(new Constant[]{n});
        String stringRep = power.stringRep();
        String expectedStringRep = "x^3.0";
        assertEquals(expectedStringRep, stringRep);
    }

    @Test
    void solve() {
        Constant n = new SimpleConstant(3);
        Power power = new Power(new Constant[]{n}, false);
        double value = power.solve(new Variable[]{new SimpleVariable('x', 4)});
        double expectedValue = 64;
        assertEquals(expectedValue, value);
    }

    @Test
    void derivative() {
        Constant n = new SimpleConstant(3);
        Power power = new Power(new Constant[]{n}, false);
        String derivative = power.derivative().stringRep();
        String expectedDerivative = "+3.0*x^2.0";
        assertEquals(expectedDerivative, derivative);
    }

    @Test
    void antiDerivative() {
        Constant n = new SimpleConstant(3);
        Power power = new Power(new Constant[]{n}, false);
        String antiDerivative = power.antiDerivative().stringRep();
        String expectedAntiDerivative = "+0.25*x^4.0";
        assertEquals(expectedAntiDerivative, antiDerivative);
    }

}