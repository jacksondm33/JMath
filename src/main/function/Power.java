package function;

import base.*;

import java.lang.Math;

public class Power implements Function {

    private Constant n;
    private boolean reciprocal;

    /**
     * x ^ n
     * @param constants  Constants
     * n = constants[0]
     * @param reciprocal  If the function is reciprocated
     */
    public Power(Constant[] constants, boolean reciprocal){
        n = constants[0];
        this.reciprocal = reciprocal;
    }

    /**
     * Initializes function with constants
     * @param constants Constants
     * n = constants[0]
     */
    @Override
    public void init(Constant[] constants) {
        n = constants[0];
    }

    /**
     * Solves the function with given variable values
     * @param variables  Variable values
     * @return Solution
     */
    @Override
    public double solve(Variable[] variables) {
        if(reciprocal()){
            return 1 / Math.pow(variables[0].value(), n.value());
        }else{
            return Math.pow(variables[0].value(), n.value());
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
     * Solves for the derivative of the function
     * @return Derivative
     */
    @Override
    public Expression derivative() {
        return new SimpleExpression(new Term[]{
                new SimpleTerm(n, new Function[]{
                        new Power(new Constant[]{
                                new SimpleConstant(n.value() - 1)
                        }, false)
                })
        });
    }

    /**
     * Solves for the antiderivative of the function
     * @return Antiderivative
     */
    @Override
    public Expression antiderivative() {
        return new SimpleExpression(new Term[]{
                new SimpleTerm(new SimpleConstant(1 / (n.value() + 1)), new Function[]{
                        new Power(new Constant[]{
                                new SimpleConstant(n.value() + 1)
                        }, false)
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
