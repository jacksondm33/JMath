package base;

public class SimpleExpression implements Expression {

    private Term[] terms;
    private VariableMap variables;

    public SimpleExpression(Term[] terms){
        this.terms = terms;
        variables = new VariableMap();
        for(Term term : terms){
            VariableMap variables = term.getVariables();
            for(char var : variables.keySet()){
                this.variables.put(var, variables.get(var));
            }
        }
    }

    @Override
    public Term[] getTerms() {
        return terms;
    }

    @Override
    public VariableMap getVariables() {
        return variables;
    }

    @Override
    public void put(char var, double value) {
        variables.put(var, value);
        for(Term term : terms){
            term.put(var, value);
        }

    }

    @Override
    public double solve() throws ArithmeticException {
        int solution = 0;
        for(Term term : terms){
            solution += term.solve();
        }
        return solution;
    }

    @Override
    public Expression solve(VariableMap variables) throws ArithmeticException{
        Term[] terms = new Term[this.terms.length];
        for(int i = 0; i < this.terms.length; i++) {
            terms[i] = (Term) this.terms[i].solve(variables);
        }
        return new SimpleExpression(terms);
    }

    @Override
    public Function derivative() {
        return null;
    }

    @Override
    public Function antiderivative() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Term term : terms){
            sb.append(term);
            sb.append("+");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
