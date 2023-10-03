package Practice2;

/*
Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = fileLogger("t2-log.txt");
        int[] array = createRandomArray(5, 0, 10);

        bubbleSort(array, fileWriter);
    }

    public static FileWriter fileLogger(String filename) throws IOException {
        return new FileWriter(filename, true);
    }

    public static void bubbleSort(int[] array, FileWriter fileWriter) throws IOException {
        fileWriter.append("==== Bubble sort log ====\n");
        fileWriter.write("Initial array: " + Arrays.toString(array) + "\n");
        for (int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j + 1] < array[j]) {
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
            fileWriter.write(String.format("Step %d: ", i+1));
            fileWriter.write(Arrays.toString(array)+"\n");
        }
        fileWriter.append("==== Sorting finished ====\n\n");
        fileWriter.flush();
        fileWriter.close();
    }

    public static int[] createRandomArray(int size, int lowerBound, int higherBound){
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(lowerBound, higherBound);
        }
        return array;
    }
}
