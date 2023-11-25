public class IntArray {
    private int[] array;

    public IntArray(int[] array) {
        this.array = array;
    }

    public double getAverage() throws IllegalAccessException {
        if (array.length == 0)
            throw new IllegalArgumentException("Array can't be empty");
        int summ = 0;
        for (int number : array) {
            summ += number;
        }
        return (double) summ /array.length;
    }
}
