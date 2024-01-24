/**
 * 2. Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами переданного не пустого массива.
 */

import java.util.Arrays;

public class ArrayDifference {

    public static int findMin(int[] array) {
        return Arrays.stream(array).min().getAsInt();
    }
    public static int findMax(int[] array) {
        return Arrays.stream(array).max().getAsInt();
    }
    public static int findMinMaxDifference(int[] array) {
        return findMax(array) - findMin(array);
    }

    public static void main(String[] args) {
        System.out.println(findMinMaxDifference(new int[]{1, 2, -1, 5, 10}));
    }
}
