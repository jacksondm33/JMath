package base;

public interface Function {
    VariableMap getVariables();
    void put(char var, double value);
    double solve() throws ArithmeticException;
    Function solve(VariableMap variables) throws ArithmeticException;
    Function derivative();
    Function antiderivative();
}
