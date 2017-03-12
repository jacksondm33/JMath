package base;

import function.Exponential;
import function.Power;

public class Tools {



    public static Function toFunction(String string){
        String[] parts;
        if(containsVariable(string)){
            if(string.split("\\^").length > 1){
                parts = string.split("\\^");
                if(containsVariable(parts[0]) && containsVariable(parts[1])){
                    System.out.println("WARNING: x^x");
                    return null; // x^x
                }
                else if(containsVariable(parts[0])){
                    return new Power(toFunction(parts[0]), toConstant(parts[1])); // x^n
                }
                else if(containsVariable(parts[1])){
                    return new Exponential(toConstant(parts[0]), toFunction(parts[1])); // b^x
                }
                else{
                    return toConstant(string);
                }
            }
            return new SimpleVariable('x');
        }else{
            return new SimpleConstant(Double.parseDouble(string));
        }

    }

    public static Constant toConstant(String string){
        return new SimpleConstant(Double.parseDouble(string));
    }

    public static boolean containsVariable(String string){
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

}
