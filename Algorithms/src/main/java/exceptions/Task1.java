package src.main.java.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    /*
    Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println(getNumber());
        }
    }

    public static float getNumber() {
        System.out.println("Enter a decimal number");
        Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid decimal number provided");
            return getNumber();
        }
    }
}
