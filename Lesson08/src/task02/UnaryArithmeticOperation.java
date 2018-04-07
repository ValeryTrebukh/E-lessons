package task02;

public class UnaryArithmeticOperation {
    private double value;

    public UnaryArithmeticOperation() {
        value = 1.0;
    }

    public UnaryArithmeticOperation(double value) {
        this.value = value;
    }

    public void incrementValue() {
        value++;
    }

    public void decrementValue() {
        value--;
    }

    public void inverseValue() {
        value*=-1;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UnaryArithmeticOperation{" +
                "value=" + value +
                '}';
    }
}
