/**
 * 1. Написать метод, возвращающий количество чётных элементов массива.
 *
 * countEvens([2, 1, 2, 3, 4]) → 3
 * countEvens([2, 2, 0]) → 3
 * countEvens([1, 3, 5]) → 0
 */
public class EvenNumbers {
    public static int countEvens(int[] array) {
        int count = 0;
        for (int i : array) {
            if (i % 2 == 0)
                count++;
        }
        return count;
    }
}
