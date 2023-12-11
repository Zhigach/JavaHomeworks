public class BinarySearchEngine {
    /**
     * Binary search of a desired integer value.
     * @param array ascending sorted array
     * @param desiredValue value you are searching for
     * @return first met value index or -1 in case value is absent
     */
    public static int binarySearch(int[] array, int desiredValue) {
        if (!checkArguments(array))
            throw new IllegalArgumentException("Array must be sorted in ascending order");
        int lowerLimit = 0;
        int upperLimit = array.length - 1;
        int mid = lowerLimit + (upperLimit - lowerLimit) / 2;
        while (upperLimit >= lowerLimit) {
            if (array[mid] > desiredValue) {
                upperLimit = mid - 1;
            } else if (array[mid] < desiredValue) {
                lowerLimit = mid + 1;
            } else {
                return mid;
            }
            mid = lowerLimit + (upperLimit - lowerLimit) / 2;
        }
        return -1;
    }

    /**
     * Function to check array is sorted in ascending order
     * @param array sorted (or not) array
     * @return true is array is sorted in natural ascending order
     */
    private static boolean checkArguments(int[] array) {
        int prevValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < prevValue) {
                return false;
            }
            prevValue = array[i];
        }
        return true;
    }
}
