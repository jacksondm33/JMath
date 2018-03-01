package helper;

import base.*;
import function.Exponential;
import function.Power;

import java.util.ArrayList;
import java.util.List;

public class FunctionCreator {
	
	public static final String[] operations = {"(", "+", "^"};
	public static final String[] variables = {"A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k", "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q", "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z"};

    public static Function create(String string){
        System.out.println("Create - " + string);
        string = trim(string);
        System.out.println("Trimmed Create - " + string);
        if(!containsAny(string, operations)){
            System.out.println("No Operations - " + string + " -> To Function");
            return toFunction(string);
        }
        List<Term> terms = new ArrayList<>();
        List<Function> functions = new ArrayList<>();
        int start = 0;
        int depth = 0;
        boolean function = false;
        for(int i = 0; i < string.length(); i++){
            if(depth > 0){
                switch (string.charAt(i)) {
                    case '(':
                        depth += 1;
                        continue;
                    case ')':
                        if (depth > 1) {
                            depth -= 1;
                            continue;
                        }
                        break;
                    case '^':
                        if(depth == 1) {
                            function = true;
                        }
                        continue;
                    default:
                        continue;
                }
            }
            switch (string.charAt(i)) {
                case '(':
                    if (i > start) {
                        System.out.println("Function Before ( - " + string.substring(0, i));
                        functions.add(toFunction(string.substring(0, i)));
                    }
                    start = i + 1;
                    depth += 1;
                    break;
                case ')':
                    if (function) {
                        System.out.println("To Function - " + string.substring(start, i));
                        functions.add(toFunction(string.substring(start, i)));
                        function = false;
                    } else {
                        functions.add(create(string.substring(start, i)));
                    }
                    start = i + 1;
                    depth -= 1;
                    break;
                case '+':
                    if (i > start) {
                        System.out.println("Function Before + - " + string.substring(start, i));
                        functions.add(create(string.substring(start, i)));
                    }
                    System.out.println("Term Created - " + string.substring(0, i));
                    terms.add(new SimpleTerm(functions.toArray(new Function[0])));
                    functions = new ArrayList<>();
                    start = i + 1;
                    break;
            }
        }
        terms.add(new SimpleTerm(functions.toArray(new Function[0])));
        return new SimpleExpression(terms.toArray(new Term[0]));
    }

    private static Function toFunction(String string){
        string = trim(string);
        String[] parts;
        if(containsAny(string, variables)){
            if(string.contains("^")){
                parts = string.split("\\^");
                if(containsAny(parts[0], variables) && containsAny(parts[1], variables)){
                    System.out.println("Not Implemented - x^x");
                    return null; // x^x
                }else if(containsAny(parts[0], variables)){
                    return new Power(create(parts[0]), toConstant(parts[1])); // x^n
                }else if(containsAny(parts[1], variables)){
                    return new Exponential(toConstant(parts[0]), create(parts[1])); // b^x
                }else{
                    return toConstant(string);
                }
            }
            return new SimpleVariable(string.charAt(0));
        }else{
            return toConstant(string);
        }

    }

    private static Constant toConstant(String string){
        string = trim(string);
        return new SimpleConstant(Double.parseDouble(string));
    }

    private static boolean containsAny(String string , String[] strings){
        for(String s : strings) {
        	if(string.contains(s)) {
        		return true;
        	}
        }
        return false;
    }

    private static String trim(String string){
        StringBuilder sb = new StringBuilder(string);
        for(;;) {
            if (checkTrim(sb.toString())){
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
            }else{
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
            }else if(string.charAt(i) == ')'){
                depth -= 1;
            }
            if(depth == 0){
                return false;
            }
        }
        return true;
    }

}
