package Practice5;

import java.util.ArrayList;
import java.util.Random;

/* ODO: Реализовать алгоритм пирамидальной сортировки (HeapSort)
*   пусть будет сортировка по возрастанию*/
public class Task2_1 {
    public static void main(String[] args) {
        ArrayList<Integer> array = createRandomArray(7, 0, 15);
        System.out.println(array);
        for (int i = array.size() / 2 - 1; i >= 0; i--) // преобразование в кучу
            heapify(array, i, array.size());
        System.out.println(array);
        heapSort(array); // сортировка из Max кучи
        System.out.println(array);
    }

    public static void heapSort (ArrayList<Integer> array) {
        for (int size = array.size() - 1; size >= 0; size--) {
            swapValues(array, 0, size);
            System.out.println(array);
            heapify(array, 0, size);
        }
    }
    public static int left (int i) { return 2 * i + 1;}
    public static int right (int i) { return 2 * i + 2;}
    public static void swapValues (ArrayList<Integer> array, int firstIndex, int secondIndex) {
        int carrier = array.get(firstIndex);
        array.set(firstIndex, array.get(secondIndex));
        array.set(secondIndex, carrier);
    }
    public static void heapify(ArrayList<Integer> treeArray, int nodeIndex, int limit) {
        //printTree(treeArray);
        int left = left(nodeIndex);
        int right = right(nodeIndex);
        int maxValueIndex = nodeIndex;
        if (left < limit && treeArray.get(left) > treeArray.get(maxValueIndex)) {
            maxValueIndex = left;
        }
        if (right < limit && treeArray.get(right) > treeArray.get(maxValueIndex)) {
            maxValueIndex = right;
        }
        if (maxValueIndex != nodeIndex) {
            swapValues(treeArray, nodeIndex, maxValueIndex);
            heapify(treeArray, maxValueIndex, limit);
        }
    }
    public static ArrayList<Integer> createRandomArray (int size, int lowerBound, int upperBound ) {
        ArrayList<Integer> result = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++)
            result.add(random.nextInt(lowerBound, upperBound));
        return result;
    }
    public static void printTree (ArrayList<Integer> treeArray) {
        int i = 0;
        int tmpCounter = 1;
        int levelSize = 1;
        while (i < treeArray.size()) {
            System.out.printf("%d ", treeArray.get(i));
            i++;
            tmpCounter++;
            if (tmpCounter > levelSize) {
                levelSize *= 2;
                tmpCounter = 1;
                System.out.println();
            }
        }
    }
}
