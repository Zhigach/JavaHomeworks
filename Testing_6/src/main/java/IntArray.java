/**
 * Basic wrapper for primitive integer array,
 * contains method of average value calculation.
 */
public class IntArray {
    /**
     * Primitive integer array.
     * Current implementation allows you to create zero size arrays,
     * but calculations can be done only for non-zero length.
     */
    private final int[] array;

    /**
     * Standard constructor. Pass int[] array as argument.
     * @param arr primitive integer array
     */
    public IntArray(final int[] arr) {
        this.array = arr;
    }


    /**
     * Method used to find average array value.
     * @return average value
     */
    public double getAverage()  {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array can't be empty");
        }
        int summ = 0;
        for (int number : array) {
            summ += number;
        }
        return (double) summ / array.length;
    }
}
