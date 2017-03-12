package function;

import base.*;
import function.Power;
import org.junit.Test;
import static org.junit.Assert.*;

public class PowerTest {

    @Test
    public void solve() {
        Constant n = new SimpleConstant(3);
        Power power = new Power(n);
        power.put('x', 4.0);
        double value = power.solve();
        double expectedValue = 64;
        assertEquals(expectedValue, value, 0);
    }

    @Test
    public void derivative() {
//        Constant n = new SimpleConstant(3);
//        Power power = new Power(n);
//        String derivative = power.derivative().toString();
//        String expectedDerivative = "+3.0*x^2.0";
//        assertEquals(expectedDerivative, derivative);
    }

    @Test
    public void antiderivative() {
//        Constant n = new SimpleConstant(3);
//        Power power = new Power(n);
//        String antiderivative = power.antiderivative().toString();
//        String expectedAntiderivative = "+0.25*x^4.0";
//        assertEquals(expectedAntiderivative, antiderivative);
    }

}