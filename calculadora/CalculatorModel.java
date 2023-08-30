package calculadora;


public class CalculatorModel implements CalculatorOperations {
    private int n1, n2, r;
    private char op;

    public CalculatorModel() {
        n1 = n2 = r = 0;
        op = '\0';
    }

    public void setOperator(char operator) {
        op = operator;
    }

    public void setNumber(int number) {
        if (op == '\0') {
            n1 = number;
        } else {
            n2 = number;
        }
    }

    public void calculate() {
        switch (op) {
            case '+':   r = n1 + n2;  break;
            case '-':   r = n1 - n2;  break;
            case '*':   r = n1 * n2;  break;
            case '/':   r = n1 / n2;  break;
            case '^':   r = calculatePower(n1, n2); break;
            case '√':   r = calculateSquareRoot(n1); break;
        }
    }

    private int calculatePower(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    private int calculateSquareRoot(int num) {
        int t;
        int sqrtroot = num / 2;
        do {
            t = sqrtroot;
            sqrtroot = (t + (num / t)) / 2;
        } while ((t - sqrtroot) != 0);
        return sqrtroot;
    }
    
    

    public int getResult() {
        return r;
    }

    public void clear() {
        n1 = n2 = r = 0;
        op = '\0';
    }
    @Override
    public int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':   return operand1 + operand2;
            case '-':   return operand1 - operand2;
            case '*':   return operand1 * operand2;
            case '/':   return operand1 / operand2;
            case '^':   return calculatePower(operand1, operand2);
            case '√':   return calculateSquareRoot(operand1);
            default:    throw new IllegalArgumentException("Invalid operator");
        }
    }

    @Override
    public void calculatePower() {
        r = calculatePower(n1, n2);
        
    }

    @Override
    public void calculateSquareRoot() {
        if (n1 < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        
        double t;
        double sqrtroot = n1 / 2.0; // Initialize with a better approximation
        do {
            t = sqrtroot;
            sqrtroot = (t + n1 / t) / 2.0; // Improve the approximation
        } while (Math.abs(t - sqrtroot) > 1e-10); // Use a small tolerance for convergence
    
        r = (int) sqrtroot; // Convert back to integer for the result
    }
    

}
