package function;

import base.*;

import java.lang.Math;

public class Power implements Function {

    private Constant n;
    private Constant h;
    private Constant a;
    private boolean reciprocal;
    private byte type;

    /**
     * x ^ n
     * @param n  Constant
     * @param reciprocal  If the function is reciprocated
     */
    public Power(Constant n, boolean reciprocal){
        this.n = n;
        this.h = new SimpleConstant(0);
        this.a = new SimpleConstant(1);
        this.reciprocal = reciprocal;
        this.type = 0;
    }

    /**
     * (x - h) ^ n
     * @param n  Constant
     * @param h  Constant
     * @param reciprocal  If the function is reciprocated
     */
    public Power(Constant n, Constant h, boolean reciprocal){
        this.n = n;
        this.h = h;
        this.a = new SimpleConstant(1);
        this.reciprocal = reciprocal;
        this.type = 1;
    }

    /**
     * (ax - h) ^ n
     * @param n  Constant
     * @param h  Constant
     * @param a  Constant
     * @param reciprocal  If the function is reciprocated
     */
    public Power(Constant n, Constant h, Constant a, boolean reciprocal){
        this.n = n;
        this.h = h;
        this.a = a;
        this.reciprocal = reciprocal;
        this.type = 2;
    }

    /**
     * Solves the function with the given value of x
     * @param x  Variable
     * @return Solution
     */
    private double solve(Variable x) throws ArithmeticException {
        if(reciprocal()){
            return 1 / Math.pow(a.value() * x.value() - h.value(), n.value());
        }else{
            return Math.pow(a.value() * x.value() - h.value(), n.value());
        }
    }

    /**
     * Solves the function with the given values
     * @param variables  Variables
     * @return Solution
     */
    @Override
    public double solve(Variable[] variables) throws ArithmeticException{
        if(variables[0].var() == 'x'){
            return solve(variables[0]);
        }else{
            return 0;
        }
    }

    /**
     * Returns whether the function is reciprocated
     * @return reciprocal
     */
    @Override
    public boolean reciprocal() {
        return reciprocal;
    }

    /**
     * Returns the derivative of the function
     * @return Derivative
     */
    @Override
    public Expression derivative() {
        return new SimpleExpression(new Term[]{
                new SimpleTerm(n, new Function[]{
                        new Power(new SimpleConstant(n.value() - 1), false)
                })
        });
    }

    /**
     * Returns the antiderivative of the function
     * @return Antiderivative
     */
    @Override
    public Expression antiderivative() {
        return new SimpleExpression(new Term[]{
                new SimpleTerm(new SimpleConstant(1 / (n.value() + 1)), new Function[]{
                        new Power(new SimpleConstant(n.value() + 1), false)
                })
        });
    }

    /**
     * Returns a String representation of the function
     * @return String representation
     */
    @Override
    public String stringRep() {
        return "x^" + n.value();
    }
}
