package base;

import base.Constant;
import base.Function;
import base.Term;

public class SimpleTerm implements Term {

    Constant constant;
    Function[] functions;

    public SimpleTerm(Constant constant, Function[] functions){
        this.constant = constant;
        this.functions = functions;
    }

    @Override
    public void setConstant(Constant constant) {
        this.constant = constant;
    }

    @Override
    public Constant constant() {
        return constant;
    }

    @Override
    public void setFunctions(Function[] functions) {
        this.functions = functions;
    }

    @Override
    public Function[] functions() {
        return functions;
    }

    @Override
    public double solve(Variable[] variables) throws ArithmeticException{
        double solution = constant.value();
        for(Function function : functions){
            solution *= function.solve(variables);
        }
        return solution;
    }

    @Override
    public Expression derivative() {
        return null;
    }

    @Override
    public Expression antiDerivative() {
        return null;
    }
}
