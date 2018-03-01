package base;

public class SimpleConstant implements Constant {

    private double value;

    public SimpleConstant(double value){
        this.value = value;
    }

    @Override
    public VariableMap getVariables() {
        return new VariableMap();
    }

    @Override
    public void put(char var, double value) {

    }

    @Override
    public double solve() throws ArithmeticException {
        return value;
    }

    @Override
    public Constant solve(VariableMap variables) throws ArithmeticException {
        return new SimpleConstant(value);
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
        return String.valueOf(value);
    }
}
