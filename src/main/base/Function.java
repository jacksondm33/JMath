package base;

public interface Function {
	
    VariableMap getVariables();
    Expression getVariable(char var);
    void setVariables(VariableMap variables);
    void setVariable(char var, Expression value);
    Expression solve() throws ArithmeticException;
    Expression solve(VariableMap variables) throws ArithmeticException;
}
