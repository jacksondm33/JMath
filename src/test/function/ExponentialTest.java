package function;

import base.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExponentialTest {

    @Test
    public void solve() {
        Constant b = new SimpleConstant(3);
        Exponential exponential = new Exponential(b);
        exponential.put('x', 4.0);
        double value = exponential.solve();
        double expectedValue = 81;
        assertEquals(expectedValue, value, 0);
    }

    @Test
    public void derivative() {
//        Constant n = new SimpleConstant(3);
//        Exponential exponential = new Exponential(n);
//        String derivative = exponential.derivative().toString();
//        String expectedDerivative = "+" + Math.log(3) + "*3.0^x";
//        assertEquals(expectedDerivative, derivative);
    }

    @Test
    public void antiderivative() {
//        Constant n = new SimpleConstant(3);
//        Exponential exponential = new Exponential(n);
//        String antiderivative = exponential.antiderivative().toString();
//        String expectedAntiderivative = "+" + 1 / Math.log(3) + "*3.0^x";
//        assertEquals(expectedAntiderivative, antiderivative);
    }

}