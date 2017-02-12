import base.*;
import function.Power;
import org.junit.Test;
import static org.junit.Assert.*;

public class PowerTest {

    @Test
    public void solve() {
        Constant n = new SimpleConstant(3);
        Power power = new Power(n, false);
        double value = power.solve(new Variable[]{new SimpleVariable('x', 4)});
        double expectedValue = 64;
        assertEquals(expectedValue, value, 0);
    }

    @Test
    public void derivative() {
        Constant n = new SimpleConstant(3);
        Power power = new Power(n, false);
        String derivative = power.derivative().stringRep();
        String expectedDerivative = "+3.0*x^2.0";
        assertEquals(expectedDerivative, derivative);
    }

    @Test
    public void antiderivative() {
        Constant n = new SimpleConstant(3);
        Power power = new Power(n, false);
        String antiderivative = power.antiderivative().stringRep();
        String expectedAntiderivative = "+0.25*x^4.0";
        assertEquals(expectedAntiderivative, antiderivative);
    }

}