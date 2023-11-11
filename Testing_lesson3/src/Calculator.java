import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);
    public boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean numberInInterval(int n) { // метод проверяет, попадает ли переданное число в интервал (25;100)
        return n > 25 && n < 100;
    }
}