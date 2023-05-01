import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
    Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
 */
public class Task2 {
    public static void main(String[] args) {
        int[] initialArray = createRandomArray(10, 0, 10);
        System.out.printf("Initial array: %s\n", Arrays.toString(initialArray));
        System.out.printf("Even numbers removed: %s\n", Arrays.toString(removeEven(initialArray)));
    }

    private static Object[] removeEven(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int item : array) {
            if (item % 2 == 1)
                arrayList.add(item);
        }
        return arrayList.toArray();
    }

    public static int[] createRandomArray(int size, int lowerBound, int higherBound) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(lowerBound, higherBound);
        }
        return array;
    }
}
