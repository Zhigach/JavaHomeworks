package homework;

import java.util.Arrays;
import java.util.Random;

/*
    Напишите программу, которая использует Stream API для обработки списка чисел.
    Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random rand = new Random(System.currentTimeMillis());
        array = Arrays.stream(array).map(x -> rand.nextInt(-50, 50)).toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.stream(array).filter(x -> x % 2 == 0).average().getAsDouble());
    }
}
