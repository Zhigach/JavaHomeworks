import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]{4,5,6,7,1,9,1,5,6,0,3};

        bubbleSort(array);
        System.out.println("array = " + Arrays.toString(array));

        array = new int[]{4,5,6,7,1,9,1,5,6,0,3};
        directSort(array);
        System.out.println("array = " + Arrays.toString(array));

        array = new int[]{4,5,6,7,1,9,1,5,6,0,3};
        insertSort(array);
        System.out.println("array = " + Arrays.toString(array));

    }

    public static void bubbleSort(int[] array) {
        boolean finished;
        do {
            finished = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    int swap = array[i];
                    array[i] = array[i+1];
                    array[i+1] = swap;
                    finished = false;
                }
            }
        } while (!finished);

    }

    public static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1 ; i++) {
            int minPoition = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minPoition]) {
                    minPoition = j;
                }
            }
            if (minPoition != i) {
                int swap = array[minPoition];
                array[minPoition] = array[i];
                array[i] = swap;
            }
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        }
    }

}
