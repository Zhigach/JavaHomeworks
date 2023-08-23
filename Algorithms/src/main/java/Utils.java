package src.main.java;

import java.util.Random;

public class Utils {
    public static int[] createRandomArray(int size, int lowerBound, int upperBound){
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = lowerBound + random.nextInt(upperBound - lowerBound);
        }
        return array;
    }

    public static void printArray(int[] array) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.print(" ]\n");
    }
}
