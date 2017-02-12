package solver;

import base.Expression;
import base.Variable;

public class Limit {

    private Expression expression;
    private byte type = 0;
    private Variable[] variables;
    private static final byte NEGATIVE_INFINITY = 0;
    private static final byte INFINITY = 1;
    private static final byte ZERO = 2;


    public Limit(Expression expression, Variable[] variables){
        this.expression = expression;
        this.variables = variables;
    }

    public double solve(){
        if(type == 0){
            findType();
        }
        return 0;
    }

    private double findType(){
        try {
            expression.solve(variables);
        } catch(ArithmeticException ae){

        }
        return 1;
    }
}
