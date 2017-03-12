package solver;

import base.*;

import java.util.ArrayList;
import java.util.List;

public class Limit {

    private Expression expression;
    private byte type = 0;
    private VariableMap variables;

    private static final byte INFINITY = 0; // +k / 0
    private static final byte NEG_INFINITY = 1; // -k / 0
    private static final byte ZERO = 1; // 0
    private static final byte NONZERO = 2; // k
    private static final byte INDETERMINATE = 3; // 0 / 0

    private static final byte TYPE1 = 1; // k or 0
    private static final byte TYPE2 = 2; // INFINITY - INFINITY
    private static final byte TYPE3 = 3; // INFINITY * 0
    private static final byte TYPE4 = 4; // INFINITY or

    public Limit(Expression expression, VariableMap variables){
        this.expression = expression;
        this.variables = variables;
    }

    public double solve(){
        if(type == 0){
            type = findType();
        }
        if(type == TYPE1){
            return expression.solve();
        }
        return 0;
    }

    private byte findType(){
        try {
            expression.solve(variables);
        } catch(ArithmeticException ae) {
            return findTypeInd();
        }
        return TYPE1;
    }

    private byte findTypeInd(){
        List<List<Byte>> valuesList = getValuesList();
        List<Byte> termValuesList = getTermValuesList(valuesList);
        if(termValuesList.contains(INFINITY) && termValuesList.contains(NEG_INFINITY)){
            return TYPE2;
        }else if(termValuesList.contains(INDETERMINATE)){
            return TYPE3;
        }else{
            return TYPE4;
        }
    }

    private List<List<Byte>> getValuesList(){
        List<List<Byte>> valuesList = new ArrayList<>();
        for(Term term : expression.getTerms()){
            List<Byte> values = new ArrayList<>();
            for(Function function : term.getFunctions()){
                double solution;
                try {
                    solution = function.solve();
                }catch (ArithmeticException ae){
                    values.add(INFINITY);
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

    private List<Byte> getTermValuesList(List<List<Byte>> valuesList){
        List<Byte> termValuesList = new ArrayList<>();
        for(List<Byte> values : valuesList){
            if(values.contains(INFINITY) && values.contains(ZERO)){
                termValuesList.add(INDETERMINATE);
            }else if(values.contains(INFINITY)){
                if(false /* Term is negative */){
                    termValuesList.add(NEG_INFINITY);
                }else{
                    termValuesList.add(INFINITY);
                }
            }else if(values.contains(ZERO)){
                termValuesList.add(ZERO);
            }else{
                termValuesList.add(NONZERO);
            }
        }
        return termValuesList;
    }
}
