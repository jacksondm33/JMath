import base.*;
import function.Exponential;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExponentialTest {

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
    public void antiderivative() {
        Constant n = new SimpleConstant(3);
        Exponential exponential = new Exponential(new Constant[]{n}, false);
        String antiderivative = exponential.antiderivative().stringRep();
        String expectedAntiderivative = "+" + 1 / Math.log(3) + "*3.0^x";
        assertEquals(expectedAntiderivative, antiderivative);
    }

}