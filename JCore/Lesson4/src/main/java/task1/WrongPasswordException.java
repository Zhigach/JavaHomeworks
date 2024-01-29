package task1;

public class WrongPasswordException extends IllegalArgumentException {
    public WrongPasswordException() {
    }

    public WrongPasswordException(String s) {
        super(s);
    }
}
