package Practice1;

/*
    Вывести все простые числа от 1 до 1000
*/

public class Task2 {
    public static void main(String[] args) {
        printSimpleNumbers(1000);
    }

    public static boolean isPrime(int n){

        if (n <= 1)
            return false;

        if (n == 2 || n == 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i*i <= n; i += 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    private static void printSimpleNumbers(int n){
        for (int i = 1; i <= n; i++) {
            if (isPrime(i))
                System.out.print(i+"\t");
        }
    }
}
