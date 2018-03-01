package base;

public class SimpleVariable implements Variable{

    private VariableMap variables;

    public SimpleVariable(char var, double value){
        variables = new VariableMap();
        variables.put(var, value);
    }

    public SimpleVariable(char var){
        variables = new VariableMap();
        variables.put(var, 0.0);
    }

    @Override
    public VariableMap getVariables() {
        return variables;
    }

    @Override
    public void put(char var, double value) {
        variables.put(var, value);
    }

    @Override
    public double solve() throws ArithmeticException {
        return (double) variables.values().toArray()[0];
    }

    @Override
    public Function solve(VariableMap variables) throws ArithmeticException {
        return this;
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
        return String.valueOf(variables.keySet().toArray()[0]);
    }

}
