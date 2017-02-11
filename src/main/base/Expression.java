package base;

public interface Expression {
    void setTerms(Term[] terms);
    Term[] terms();
    Expression derivative();
    Expression antiDerivative();
    String stringRep();
}
