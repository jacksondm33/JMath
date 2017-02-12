package base;

public interface Function {
    double solve(Variable[] variables);
    boolean reciprocal();
    Expression derivative();
    Expression antiderivative();
    String stringRep();
}
