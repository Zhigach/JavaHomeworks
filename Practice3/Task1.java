package Practice3;

import java.util.ArrayList;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> initialArray = createRandomArray(10, 0, 10);
        System.out.printf("Initial array: %s\n", initialArray);
        mergeSort(initialArray, 0, initialArray.size()-1);
        System.out.printf("Sorted array: %s\n", initialArray);
    }

    private static void mergeSort(ArrayList<Integer> arrayList, int left, int right){
        if (left >= right)
            return;
        int mid = left + (right-left) / 2;
        mergeSort(arrayList, left, mid);
        mergeSort(arrayList, mid+1, right);
        merge(arrayList, left, mid, right);
    }

    private static void merge(ArrayList<Integer> arrayList, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        ArrayList<Integer> array1 = new ArrayList<>(len1);
        ArrayList<Integer> array2 = new ArrayList<>(len2);
        for (int i = left; i <= mid; i++) {
            array1.add(arrayList.get(i));
        }
        for (int i = mid + 1; i <= right; i++) {
            array2.add(arrayList.get(i));
        }
        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            int first = array1.get(i);
            int second = array2.get(j);
            if (first <= second) {
                arrayList.set(k++, first);
                i++;
            } else {
                arrayList.set(k++, second);
                j++;
            }
        }
        while (i < len1) {
            arrayList.set(k++, array1.get(i++));
        }
        while (j < len2) {
            arrayList.set(k++, array2.get(j++));
        }
    }

    public static ArrayList<Integer> createRandomArray(int size, int lowerBound, int higherBound) {
        ArrayList<Integer> array = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(lowerBound, higherBound));
        }
        return array;
    }
}
