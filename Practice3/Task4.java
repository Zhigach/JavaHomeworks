import java.util.*;

/*
(Необязательная задача повышенной сложности)
Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:
Разность:
A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
B - A = все числа из второй коллекции, которые не содержатся в первой
Симметрическая разность:
A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой
 */
public class Task4 {
    public static void main(String[] args) {
        ArrayList<Integer> initialArray1 = createRandomArray(5, 0, 10);
        ArrayList<Integer> initialArray2 = createRandomArray(5, 0, 10);
        System.out.printf("Initial array A: %s\n", initialArray1);
        System.out.printf("Initial array B: %s\n", initialArray2);
        System.out.printf("A - B = %s\n", removeArray(initialArray1, initialArray2));
        System.out.printf("B - A = %s\n", removeArray(initialArray2, initialArray1));
        System.out.printf("Symmetric difference of A and B is %s\n", symmetricDifference(initialArray2, initialArray1));
    }

    private static ArrayList<Integer> removeArray(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int item : arr2) {
            if (!map.containsKey(item))
                map.put(item, true);
        }
        for (int item : arr1) {
            if (!map.containsKey(item)){
                result.add(item);
            }
        }
        return result;
    }

    private static ArrayList<Integer> symmetricDifference(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> directDiff = removeArray(arr1, arr2);
        ArrayList<Integer> reversedDiff = removeArray(arr2, arr1);
        ArrayList<Integer> result = new ArrayList<>(arr1.size() + arr2.size());
        result.addAll(directDiff);
        result.addAll(reversedDiff);
        return result;
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
