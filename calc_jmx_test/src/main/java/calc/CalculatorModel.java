package calc;

/**
 * Created by sam on 11/16/16.
 */
public class CalculatorModel implements CalculatorModelMBean {
    private int firstNumber;
    private int secondNumber;

    public CalculatorModel(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int add(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    public String toString() {
        return "CalculatorModel{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                '}';
    }
}
