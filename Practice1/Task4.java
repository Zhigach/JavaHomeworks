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
        System.out.println("Enter equation from template q + w = e, (e.g. 2? + ?5 = 69): ");
        //String input = scanner.nextLine();
        String testString = "2? + ?5 = 69";
        String[] numbersStrings = testString.split(" ");
        byte[][] numbers;
        numbers = new byte[][] {parseStringToInt(numbersStrings[0]),
                                parseStringToInt(numbersStrings[2]),
                                parseStringToInt(numbersStrings[4])};
        byte[][] variablesPositions = new byte[][]{};


    }
    public static byte[][] findVariables(byte[] array){
        int depth = array.length;
        byte[] result = new byte[] {};
        for (int i = 0; i < depth; i++) {
            if (array[i] == -1)

                result[i] = -1;
            else
                result[i] = Byte.parseByte(String.valueOf(numInString.charAt(i)));
        }
        return ;
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

    private static byte[][] generatePermutations(byte positionsNumber) { // честно украдено со стэковерфлоу https://stackoverflow.com/a/73374413, сам не успел осилить задачу
        //Array that holds a single permutation, e.g., {0,1,1}
        byte[][] permutations = new byte[(int) Math.pow(10, positionsNumber)][(int) Math.pow(10, positionsNumber)];
        byte[] permutation = new byte[positionsNumber];
        do {
            System.out.println(Arrays.toString(permutation));
        } while (increaseRightMostPosition(permutation));
        return permutations;
    }
    private static boolean increaseRightMostPosition(byte[] permutation) {
        for (int i = permutation.length - 1; i >= 0; i--) {
            permutation[i]++;
            if (permutation[i] > 9)
                permutation[i] = 0;
            else
                return true;
        }
        return false;
    }
}