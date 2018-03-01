package function;

import base.*;
import helper.FunctionCreator;

import java.lang.Math;

public class Power implements BaseFunction {

    private Function base;
    private Constant n;
    private VariableMap variables;

    /**
     * x ^ n
     * @param n Constant
     */
    public Power(Constant n){
        this.n = n;
        base = FunctionCreator.create("x");
        variables = new VariableMap();
        variables.put('x', 0.0);
    }

    public Power(Function base, Constant n){
        this.base = base;
        this.n = n;
        variables = base.getVariables();
    }

    @Override
    public VariableMap getVariables() {
        return variables;
    }

    @Override
    public void put(char var, double value) {
        variables.put(var, value);
        base.put(var, value);
    }

    @Override
    public double solve() throws ArithmeticException {
        return Math.pow(base.solve(), n.solve());
    }

    @Override
    public Function solve(VariableMap variables) throws ArithmeticException {
        return null;
    }

    /**
     * Returns the derivative of the function
     * @return Derivative
     */
    @Override
    public Expression derivative() {
        return null;
    }

    /**
     * Returns the antiderivative of the function
     * @return Antiderivative
     */
    @Override
    public Expression antiderivative() {
        return null;
    }

    @Override
    public String toString() {
        return "(" + base.toString() + ")^" + n.toString();
    }
}
