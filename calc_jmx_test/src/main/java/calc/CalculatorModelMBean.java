package calc;

/**
 * Created by sam on 11/16/16.
 */
public interface CalculatorModelMBean {
    int getFirstNumber();

    void setFirstNumber(int firstNumber);

    int getSecondNumber();

    void setSecondNumber(int secondNumber);

    int add(int firstNumber, int secondNumber);

    @Override
    String toString();
}
