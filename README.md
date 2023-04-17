# JavaHomeworks

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i < 10; i++) {
            System.out.println("Triangle number for " + String.valueOf(i) + " is " + String.valueOf(triangleNumber(i)));
            System.out.println("Factorial number for " + String.valueOf(i) + " is " + String.valueOf(factorial(i)));
        }

        printSimpleNumbers(1000);


    }

    private static int triangleNumber(int n){
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }
    
    public static int factorial(int n){
        int result = 1;
        if (n == 1) return 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public static boolean isPrime(int n){

        if (n <= 1)
            return false;

        if (n == 2 || n == 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    private static void printSimpleNumbers(int n){
        for (int i = 1; i <= n; i++) {
            if (isPrime(i))
                System.out.print(String.valueOf(i+"\t"));
        }
    }
}
