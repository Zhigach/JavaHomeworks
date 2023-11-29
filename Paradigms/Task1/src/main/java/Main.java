import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void sort_list_imperative(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static int[] sort_declarative(int[] array) {
        return Arrays.stream(array).boxed().
                sorted(Collections.reverseOrder()).
                mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] exampleArr = {4, 6 ,1, -10, 0, 5, 199};
        System.out.println(Arrays.toString(exampleArr));
        int[] sorted = Arrays.copyOf(exampleArr, exampleArr.length);
        //sort_list_imperative(sorted);
        sorted = sort_declarative(sorted);
        System.out.println(Arrays.toString(sorted));

    }
}
