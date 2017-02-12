package base;

import base.Constant;
import base.Function;

public interface Term {
    void setConstant(Constant constant);
    Constant constant();
    void setFunctions(Function[] functions);
    Function[] functions();
    double solve(Variable[] variables) throws ArithmeticException;
    Expression derivative();
    Expression antiDerivative();
}
