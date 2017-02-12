package base;

public interface Expression {
    void setTerms(Term[] terms);
    Term[] terms();
    double solve(Variable[] variables) throws ArithmeticException;
    Expression derivative();
    Expression antiDerivative();
    String stringRep();
}
