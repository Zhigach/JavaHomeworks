package src.main.java.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */
public class Task4 {
    public static void main(String[] args) throws Exception {
        while (true) {
            try {
                System.out.println(getNonEmptyString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getNonEmptyString() throws Exception {
        System.out.println("Enter a non-empty string (row)");
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        if (res != "") {
            return res;
        } else {
            throw new Exception("Method does not support empty strings");
        }
    }
}
