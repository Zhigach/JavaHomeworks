package Practice2;

/*
    К калькулятору из предыдущего дз добавить логирование.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) throws IllegalStateException, IOException {
        int choice;
        FileWriter fileWriter = new FileWriter(new File("t4-log.txt"));
        fileWriter.write("===> Session started\n");
        while (true){
            choice = showMenu();
            if (choice == 0) {
                System.out.println("Program will exit now.");
                break;
            }
            int a = askForInteger("Enter A value: ");
            int b = askForInteger("Enter B value: ");
            switch (choice) {
                case (1) -> logAction(fileWriter,"A + B = " + sum(a, b));
                case (2) -> logAction(fileWriter,"A - B = " + difference(a, b));
                case (3) -> logAction(fileWriter, "A * B = " + product(a, b));
                case (4) -> logAction(fileWriter,"Integer part of A / B = " + division(a, b));
                case (5) -> logAction(fileWriter, "Remainder of A / B = " + remainder(a, b));
            }
        }
        fileWriter.write("<=== Session finished\n\n");
        fileWriter.flush();
        fileWriter.close();
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
        if (b != 0)
            return a/b;
        System.out.println("ERROR: Division by 0");
        return Integer.MAX_VALUE;
    }
    private static int remainder(int a, int b){
        if (b != 0)
            return a%b;
        System.out.println("ERROR: Division by 0");
        return Integer.MIN_VALUE;
    }
    private static void logAction(FileWriter logger, String record) throws IOException {
        System.out.println(record);
        logger.append(LocalDateTime.now()
                .toString()).append(" ")
                .append(record)
                .append("\n");
    }
}
