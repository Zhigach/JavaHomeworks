package task2;

public class AmountException extends RuntimeException {
    int incorrectValue;
    public AmountException() {
    }

    public AmountException(String message, int incorrectValue) {
        super(message);
        this.incorrectValue = incorrectValue;
    }
}
