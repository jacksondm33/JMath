package helper;

import base.*;
import function.Exponential;
import function.Power;

import java.util.ArrayList;
import java.util.List;

public class FunctionCreator {

    public static Function create(String string){
        System.out.println(string + " - START CREATE");
        string = trim(string);
        System.out.println(string + " - TRIM CREATE");
        if(!string.contains("(")){
            System.out.println(string + " - NO () TO_FUNCTION");
            return toFunction(string);
        }
        List<Term> terms = new ArrayList<>();
        List<Function> functions = new ArrayList<>();
        int start = 0;
        int depth = 0;
        boolean function = false;
        for(int i = 0; i < string.length(); i++){
            if(depth > 0){
                if(string.charAt(i) == '('){
                    depth += 1;
                    continue;
                }
                else if(string.charAt(i) == ')'){
                    if(depth > 1){
                        depth -= 1;
                        continue;
                    }
                }
                else if(depth == 1 && string.charAt(i) == '^'){
                    function = true;
                }
            }
            if(string.charAt(i) == '('){
                start = i + 1;
                depth += 1;
            }
            else if(string.charAt(i) == ')'){
                System.out.print(string.substring(start, i));
                if(function){
                    System.out.println(" - TO_FUNCTION");
                    functions.add(toFunction(string.substring(start, i)));
                }else {
                    System.out.println(" - CREATE");
                    functions.add(create(string.substring(start, i)));
                }
                depth -= 1;
            }
            else if(string.charAt(i) == '+'){
                terms.add(new SimpleTerm(functions.toArray(new Function[0])));
                functions = new ArrayList<>();
            }

        }
        terms.add(new SimpleTerm(functions.toArray(new Function[0])));
        return new SimpleExpression(terms.toArray(new Term[0]));
    }

    private static Function toFunction(String string){
        System.out.println(string + " - START TO_FUNCTION");
        string = trim(string);
        System.out.println(string + " - TRIM TO_FUNCTION");
        String[] parts;
        if(containsVariable(string)){
            if(string.split("\\^").length > 1){
                parts = string.split("\\^");
                if(containsVariable(parts[0]) && containsVariable(parts[1])){
                    System.out.println("WARNING: x^x");
                    return null; // x^x
                }
                else if(containsVariable(parts[0])){
                    return new Power(create(parts[0]), toConstant(parts[1])); // x^n
                }
                else if(containsVariable(parts[1])){
                    return new Exponential(toConstant(parts[0]), create(parts[1])); // b^x
                }
                else{
                    return toConstant(string);
                }
            }
            return new SimpleVariable(string.charAt(0));
        }else{
            return new SimpleConstant(Double.parseDouble(string));
        }

    }

    private static Constant toConstant(String string){
        System.out.println(string + " - START TO_CONSTANT");
        string = trim(string);
        System.out.println(string + " - TRIM TO_CONSTANT");
        return new SimpleConstant(Double.parseDouble(string));
    }

    private static boolean containsVariable(String string){
        return  string.contains("A") || string.contains("a") ||
                string.contains("B") || string.contains("b") ||
                string.contains("C") || string.contains("c") ||
                string.contains("D") || string.contains("d") ||
                string.contains("E") || string.contains("e") ||
                string.contains("F") || string.contains("f") ||
                string.contains("G") || string.contains("g") ||
                string.contains("H") || string.contains("h") ||
                string.contains("I") || string.contains("i") ||
                string.contains("J") || string.contains("j") ||
                string.contains("K") || string.contains("k") ||
                string.contains("L") || string.contains("l") ||
                string.contains("M") || string.contains("m") ||
                string.contains("N") || string.contains("n") ||
                string.contains("O") || string.contains("o") ||
                string.contains("P") || string.contains("p") ||
                string.contains("Q") || string.contains("q") ||
                string.contains("R") || string.contains("r") ||
                string.contains("S") || string.contains("s") ||
                string.contains("T") || string.contains("t") ||
                string.contains("U") || string.contains("u") ||
                string.contains("V") || string.contains("v") ||
                string.contains("W") || string.contains("w") ||
                string.contains("X") || string.contains("x") ||
                string.contains("Y") || string.contains("y") ||
                string.contains("Z") || string.contains("z");
    }

    private static String trim(String string){
        StringBuilder sb = new StringBuilder(string);
        for(;;) {
            if (checkTrim(sb.toString())){
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
            }
            else{
                break;
            }
        }
        return sb.toString();
    }

    private static boolean checkTrim(String string){
        int depth = 0;
        if(string.charAt(0) != '(' || string.charAt(string.length() - 1) != ')'){
            return false;
        }
        for(int i = 0; i < string.length() - 1; i++){
            if(string.charAt(i) == '('){
                depth += 1;
            }
            else if(string.charAt(i) == ')'){
                depth -= 1;
            }
            if(depth == 0){
                return false;
            }
        }
        return true;
    }

}
