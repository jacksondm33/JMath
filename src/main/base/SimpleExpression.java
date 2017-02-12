package base;

import java.util.ArrayList;
import java.util.List;

public class SimpleExpression implements Expression {

    Term[] terms;

    public SimpleExpression(Term[] terms){
        this.terms = terms;
    }

    @Override
    public void setTerms(Term[] terms) {
        this.terms = terms;
    }

    @Override
    public Term[] terms() {
        return terms;
    }

    @Override
    public double solve(Variable[] variables) throws ArithmeticException{
        double solution = 0;
        for(Term term : terms) {
            solution += term.solve(variables);
        }
        return solution;
    }

    @Override
    public Expression derivative() {
        List<Term> derivative = new ArrayList<>();
        for(Term term : terms) {
            for(Term term1 : term.derivative().terms()){
                derivative.add(term1);
            }
        }
        return new SimpleExpression((Term[]) derivative.toArray());
    }

    @Override
    public Expression antiDerivative() {
        List<Term> antiDerivative = new ArrayList<>();
        for(Term term : terms) {
            for(Term term1 : term.antiDerivative().terms()){
                antiDerivative.add(term1);
            }
        }
        return new SimpleExpression((Term[]) antiDerivative.toArray());
    }

    @Override
    public String stringRep() {
        StringBuilder sb = new StringBuilder();
        for(Term term : terms){
            if(term.constant().value() > 0){
                sb.append("+");
            }
            sb.append(term.constant().value());
            for(Function function : term.functions()){
                if(function.reciprocal()){
                    sb.append("/");
                }else{
                    sb.append("*");
                }
                sb.append(function.stringRep());
            }
        }
        return sb.toString();
    }

}
