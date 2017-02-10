package base;

import base.Constant;

public class SimpleConstant implements Constant {

    double value;

    public SimpleConstant(double value){
        this.value = value;
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
