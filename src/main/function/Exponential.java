package function;

import base.*;

import java.lang.Math;

public class Exponential implements Function{

    private Constant b;
    private boolean reciprocal;

    public Exponential(Constant[] constants, boolean reciprocal){
        b = constants[0];
        this.reciprocal = reciprocal;
    }

    @Override
    public double solve(Variable[] variables) {
        if(reciprocal()){
            return 1 / Math.pow(b.value(), variables[0].value());
        }else{
            return Math.pow(b.value(), variables[0].value());
        }
    }

    @Override
    public boolean reciprocal() {
        return reciprocal;
    }

    @Override
    public Expression derivative() {
        return new SimpleExpression(new Term[]{
                new SimpleTerm(new SimpleConstant(Math.log(b.value())), new Function[]{
                        new Exponential(new Constant[]{
                                new SimpleConstant(b.value())
                        }, false)
                })
        });
    }

    @Override
    public Expression antiderivative() {
        return new SimpleExpression(new Term[]{
                new SimpleTerm(new SimpleConstant(1 / Math.log(b.value())), new Function[]{
                        new Exponential(new Constant[]{
                                new SimpleConstant(b.value())
                        }, false)
                })
        });
    }

    @Override
    public String stringRep() {
        return b.value() + "^x";
    }
}
