package solver;

import base.Expression;
import base.Function;
import base.Term;
import base.Variable;

import java.util.ArrayList;
import java.util.List;

public class Limit {

    private Expression expression;
    private byte type = 0;
    private Variable[] variables;
    private static final byte NEGATIVE_INFINITY = 0;
    private static final byte INFINITY = 1;
    private static final byte ZERO = 2;
    private static final byte NONZERO = 3;
    private static final byte MAX_FUNCTIONS = 10;


    public Limit(Expression expression, Variable[] variables){
        this.expression = expression;
        this.variables = variables;
    }

    public double solve(){
        if(type == 0){
            type = findType();
        }
        return 0;
    }

    private byte findType(){
        try {
            expression.solve(variables);
        } catch(ArithmeticException ae) {
            return findTypeInd();
        }
        return 1;
    }

    private byte findTypeInd(){
        List<List<Byte>> valuesList = getValuesList();
        return 0;
    }

    private List<List<Byte>> getValuesList(){
        List<List<Byte>> valuesList = new ArrayList<>();
        for(Term term : expression.terms()){
            List<Byte> values = new ArrayList<>();
            for(Function function : term.functions()){
                double solution = 0;
                try {
                    solution = function.solve(variables);
                }catch (ArithmeticException ae){
                    if(true /* Function limits to negative infinity */){
                        values.add(NEGATIVE_INFINITY);
                    }else{
                        values.add(INFINITY);
                    }
                    continue;
                }
                //Only executed if there is no ArithmeticException
                if(solution == 0){
                    values.add(ZERO);
                }else{
                    values.add(NONZERO);
                }
            }
            valuesList.add(values);
        }
        return valuesList;
    }
}
