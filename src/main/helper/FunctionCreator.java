package helper;

import base.*;

public class FunctionCreator {

    public static Function create(String string){
        String[] stringTerms = string.split("\\+");
        Term[] terms = new Term[stringTerms.length];
        for(int i = 0; i < stringTerms.length; i++){
            String[] stringFunctions = stringTerms[i].split("\\*");
            Function[] functions = new Function[stringFunctions.length];
            for(int j = 0; j < stringFunctions.length; j++){
                functions[j] = Tools.toFunction(stringFunctions[j]);
            }
            terms[i] = new SimpleTerm(functions);
        }
        return new SimpleExpression(terms);
    }
}
