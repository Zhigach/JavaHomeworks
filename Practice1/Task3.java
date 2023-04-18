import java.util.Scanner;

/*
    Реализовать простой калькулятор
 */
public class Main {
    public static void main(String[] args) throws IllegalStateException {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0){
            choice = showMenu();
            if (choice == 0) {
                System.out.println("Program will exit now.");
                break;
            }
            int a = askForInteger("Enter A value: ");
            int b = askForInteger("Enter B value: ");
            switch (choice) {
                case (1) -> System.out.println("A + B = " + sum(a, b));
                case (2) -> System.out.println("A - B = " + difference(a, b));
                case (3) -> System.out.println("A * B = " + product(a, b));
                case (4) -> System.out.println("Integer part of A / B = " + division(a, b));
                case (5) -> System.out.println("Remainder of A / B = " + remainder(a, b));
            }
        }
    }

    private static int askForInteger(String message){
        System.out.print(message);
        return new Scanner(System.in).nextInt();
    }
    private static int showMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        String message = """
                Choose arithmetic operation you wish to do:
                1. Sum two integer numbers (A+B);
                2. Reduce one number by another (A-B);
                3. Find product (A*B);
                4. Calculate integer part of division (A/B);
                5. Find division remainder of A/B.
                If you wish to finish enter '0'.
                """;
        System.out.println(message);
        choice = scanner.nextInt();
        while (choice > 5 || choice < 1 && 0 != choice) {
            System.out.println("Wrong value specified. Try again.");
            System.out.println(message);
            choice = scanner.nextInt();
        }
        return choice;
    }
    private static int sum(int a, int b){
        return a+b;
    }
    private static int difference(int a, int b){
        return a-b;
    }
    private static int product(int a, int b){
        return a*b;
    }
    private static int division(int a, int b){
        return a/b;
    }
    private static int remainder(int a, int b){
        return a%b;
    }

}

