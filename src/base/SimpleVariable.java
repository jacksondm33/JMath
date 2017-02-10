package base;

public class SimpleVariable implements Variable{

    char var;
    double value;

    public SimpleVariable(char var, double value){
        this.var = var;
        this.value = value;
    }

    @Override
    public void setVar(char var) {
        this.var = var;
    }

    @Override
    public char var() {
        return var;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double value() {
        return value;
    }

}
