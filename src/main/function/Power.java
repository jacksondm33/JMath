package function;

import base.*;

import java.lang.Math;

public class Power implements Function {

    private Constant n;
    private boolean reciprocal;

    public Power(Constant[] constants, boolean reciprocal){
        n = constants[0];
        this.reciprocal = reciprocal;
    }

    @Override
    public void init(Constant[] constants) {
        n = constants[0];
    }

    @Override
    public double solve(Variable[] variables) {
        if(reciprocal()){
            return 1 / Math.pow(variables[0].value(), n.value());
        }else{
            return Math.pow(variables[0].value(), n.value());
        }
    }

    @Override
    public boolean reciprocal() {
        return reciprocal;
    }

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

    @Override
    public Expression antiDerivative() {
        return new SimpleExpression(new Term[]{
                new SimpleTerm(new SimpleConstant(1 / (n.value() + 1)), new Function[]{
                        new Power(new Constant[]{
                                new SimpleConstant(n.value() + 1)
                        }, false)
                })
        });
    }

    @Override
    public String stringRep() {
        return "x^" + n.value();
    }
}
