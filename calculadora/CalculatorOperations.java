package calculadora;



public interface CalculatorOperations {
    int performOperation(int operand1, int operand2, char operator);
    void clear();
    int getResult();
    void calculate();
    void setOperator(char charAt);
    void setNumber(int num);
    void calculatePower();
    void calculateSquareRoot();
}
