package task1;

public class WrongLoginException extends IllegalArgumentException {
    public WrongLoginException() {
    }

    public WrongLoginException(String s) {
        super(s);
    }
}
