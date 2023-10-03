package Practice1;

import java.util.Scanner;

/*
    Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
*/

public class Task1 {
    public static void main(String[] args) {

        // test();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        int n = scanner.nextInt();
        System.out.printf("Triangle number for %d is %d\n", n, triangleNumber(n));
        System.out.printf("Factorial number for %d is %d\n", n, factorial(n));
    }

    public static void test(){
        for (int i = 1; i < 10; i++)
            System.out.println("Triangle number for " + i + " is " + triangleNumber(i));

        for (int i = 1; i < 10; i++)
            System.out.println("Factorial number for " + i + " is " + factorial(i));
    }
    private static int triangleNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static int factorial(int n) {
        int result = 1;
        if (n == 1) return 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
