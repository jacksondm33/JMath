package base;

public interface Function {
    void init(Constant[] constants);
    double solve(Variable[] variables);
    boolean reciprocal();
    Expression derivative();
    Expression antiderivative();
    String stringRep();
}
