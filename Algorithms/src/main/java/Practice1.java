public class Practice1 {
    // TODO: Реализовать алгоритм пирамидальной сортировки (сортировка кучей).
    public static void main(String[] args) {
        int[] sourceArray = Utils.createRandomArray(10, 0, 50);
        Utils.printArray(sourceArray);
        heapSort(sourceArray);
        Utils.printArray(sourceArray);
    }

    /**
     * Method sorting your array in ascending order
     * @param array original unsorted array
     */
    public static void heapSort(int[] array) {
        int size = array.length;
        for (int i = size/2; i >=0 ; i--) {
            heapify(array, size, i);
        }

        for (int i = size - 1; i >= 0; i--) {
            swapArrayElements(array, 0, i);
            heapify(array, i, 0);
        }

    }

    /**
     * Method creating max-heap from source array
     * @param array input array (represent heap)
     * @param size heap size
     * @param rootIndex index of heap root
     */
    private static void heapify(int[] array, int size, int rootIndex) {
        int largest = rootIndex;
        int left = 2*rootIndex + 1;
        int right = 2*rootIndex + 2;

        if (left < size && array[left] > array[largest]) {
            largest = left;
        }
        if (right < size && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != rootIndex) {
            swapArrayElements(array, largest, rootIndex);
            heapify(array, size, largest);
        }
    }

    /**
     * Auxiliary function swapping array elements
     * @param array your array
     * @param firstElementIndex index of the fist element to swap
     * @param secondElementIndex index of the second element to swap
     */
    private static void swapArrayElements(int[] array, int firstElementIndex, int secondElementIndex){
        int swap = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = swap;
    }
}
