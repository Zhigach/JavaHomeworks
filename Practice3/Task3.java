package Practice3;

import java.util.ArrayList;
import java.util.Random;

/*
    Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка.
 */
public class Task3 {
    public static void main(String[] args) {
        ArrayList<Integer> randomArray = createRandomArrayList(10, -10, 10);
        System.out.printf("Initial array: %s\n", randomArray);
        System.out.printf("Minimum number from array: %s\n", minFromList(randomArray));
        System.out.printf("Maximum number from array: %s\n", maxFromList(randomArray));
        System.out.printf("Average value of array elements: %s\n", listAverageValue(randomArray));
    }

    private static int maxFromList(ArrayList<Integer> arrayList) {
        int max = Integer.MIN_VALUE;
        for (Integer item : arrayList) {
            if (item > max) {
                max = item.intValue();
            }
        }
        return max;
    }

    private static int minFromList(ArrayList<Integer> arrayList) {
        int min = Integer.MAX_VALUE;
        for (Integer item : arrayList) {
            if (item < min) {
                min = item.intValue();
            }
        }
        return min;
    }

    private static double listAverageValue(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (Integer item : arrayList) {
            sum += item;
        }
        return (double) sum / arrayList.size();
    }

    public static ArrayList<Integer> createRandomArrayList(int size, int lowerBound, int higherBound) {
        ArrayList<Integer> arrayList = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(lowerBound, higherBound));
        }
        return arrayList;
    }
}
