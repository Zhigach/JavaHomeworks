package task2;

/**
 * Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые,
 * и false в противном случае.
 * Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
 */
public class ArraysComparator {
    public static <T, K> boolean compareArrays(T[] arrayT, K[] arrayK) {
        if (arrayT.length != arrayK.length) {
            return false;
        }
        if (arrayT[0].getClass() != arrayK[0].getClass()) {
            return false;
        }
        for (int i = 0; i < arrayT.length; i++) {
            if (!arrayT[i].equals(arrayK[i])) {
                return false;
            }
        }
        return true;
    }
}
