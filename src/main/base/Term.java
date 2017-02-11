package base;

import base.Constant;
import base.Function;

public interface Term {
    void setConstant(Constant constant);
    Constant constant();
    void setFunctions(Function[] functions);
    Function[] functions();
    Expression derivative();
    Expression antiDerivative();
}
