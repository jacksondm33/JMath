package base;

public interface Function {
    void init(Constant[] constants);
    double solve(Variable[] variables);
    boolean reciprocal();
    Expression derivative();
    Expression antiDerivative();
    String stringRep();
}
