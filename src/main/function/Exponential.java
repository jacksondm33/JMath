package function;

import base.*;
import helper.FunctionCreator;

import java.lang.Math;

public class Exponential implements BaseFunction {

    private Function exponent;
    private Constant b;
    private VariableMap variables;

    public Exponential(Constant b){
        this.b = b;
        exponent = FunctionCreator.create("x");
        variables = new VariableMap();
        variables.put('x', 0.0);
    }

    public Exponential(Constant b, Function exponent){
        this.b = b;
        this.exponent = exponent;
        variables = exponent.getVariables();
    }

    @Override
    public VariableMap getVariables() {
        return variables;
    }

    @Override
    public void put(char var, double value) {
        variables.put(var, value);
        exponent.put(var, value);
    }

    @Override
    public double solve() throws ArithmeticException {
        return Math.pow(b.solve(), exponent.solve());
    }

    @Override
    public Function solve(VariableMap variables) throws ArithmeticException {
        return null;
    }

    @Override
    public String toString() {
        return b.toString() + "^(" + exponent.toString() + ")";
    }
}
