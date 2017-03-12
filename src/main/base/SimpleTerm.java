package base;

public class SimpleTerm implements Term {

    private Function[] functions;
    private VariableMap variables;

    public SimpleTerm(Function[] functions){
        this.functions = functions;
        variables = new VariableMap();
        for(Function function : functions){
            System.out.println(function);
            VariableMap variables = function.getVariables();
            for(char var : variables.keySet()){
                this.variables.put(var, variables.get(var));
            }
        }
    }

    @Override
    public Function[] getFunctions() {
        return functions;
    }

    @Override
    public VariableMap getVariables() {
        return variables;
    }

    @Override
    public void put(char var, double value) {
        variables.put(var, value);
        for(Function function : functions){
            function.put(var, value);
        }
    }

    @Override
    public double solve() throws ArithmeticException {
        int solution = 1;
        for(Function function : functions){
            solution *= function.solve();
        }
        return solution;
    }

    @Override
    public Term solve(VariableMap variables) throws ArithmeticException{
        Function[] functions = new Function[this.functions.length];
        for(int i = 0; i < this.functions.length; i++) {
            functions[i] = this.functions[i].solve(variables);
        }
        return new SimpleTerm(functions);
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
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Function function : functions){
            sb.append("*");
            sb.append(function);
        }
        return sb.toString();
    }
}
