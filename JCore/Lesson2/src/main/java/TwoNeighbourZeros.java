/**
 * 3. Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
 */
public class TwoNeighbourZeros {
    public static boolean hasTwoNeighbourZeros(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1] && array[i] == 0) {
                return true;
            }
        }
        return false;
    }
}
