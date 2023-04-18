/*
 * +Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
    Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.

    Исхдим из предположения, что числа двузначные
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String testString = "2? + ?5 = 69";
        String[] numbersStrings = testString.split(" ");
        byte[][] numbers;
        numbers = new byte[][] {parseStringToInt(numbersStrings[0]),
                                parseStringToInt(numbersStrings[2]),
                                parseStringToInt(numbersStrings[4])};
        byte[] testArr = new byte[] {1, 0, 0, 0};
        recursiveIter(testArr);


    }
    public static byte[] parseStringToInt(String numInString){ // -1 replaces ? - variable value
        int depth = numInString.length();
        byte[] result = new byte[depth];
        for (int i = 0; i < depth; i++) {
            if (numInString.charAt(i) == '?')
                result[i] = -1;
            else
                result[i] = Byte.parseByte(String.valueOf(numInString.charAt(i)));
        }
        return result;
    }
    private static int[] findPossibleNumbers(int[] a, int[] b, int[] result){

        return new int[] {0};
    }

    private static void recursiveIter(byte[] arr){ //assume the 0 element is an index of previously changed
        System.out.println(Arrays.toString(arr));
        if (arr[0] + 1 >= arr.length || arr[arr[0]] == 9)
            return;
        else {
            for (int i = 0; i < 9; i++) {
                arr[arr[0]]++;
                byte[] arrayCopy = new byte[arr.length];
                System.arraycopy(arr,0, arrayCopy, 0, arr.length);
                arrayCopy[0]++;
                recursiveIter(arrayCopy);
            }
        }
    }
}