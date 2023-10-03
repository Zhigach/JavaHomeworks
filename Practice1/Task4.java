package Practice1;

/*
 * +Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
    Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.

    Исхдим из предположения, что числа двузначные
 */
// мне самому не нравится как выглядит решение, но из-за нехватки времени не успеваю придумать более элегантное решение.
// хочу научится в джаву

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Task4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter equation from template q + w = e, (e.g. 2? + ?5 = 69): ");
        String inputString = scanner.nextLine();
        if (inputString == null)
            inputString = "2? + ?3 = 6?";
        String[] numbersStrings = inputString.split(" ");
        int sum = 0;
        int count = 0;
        sum += parseStringToInt(numbersStrings[0])[0];
        sum += parseStringToInt(numbersStrings[2])[0];
        sum -= parseStringToInt(numbersStrings[4])[0]; // '-' is intended
        count += parseStringToInt(numbersStrings[0])[1];
        count += parseStringToInt(numbersStrings[2])[1];
        count += parseStringToInt(numbersStrings[4])[1];

        int[] weights = mapWeights(inputString, count);
        byte[][] permutations = generatePermutations((byte) count);

        checkMatchingNumbers(permutations, weights, sum);
    }


    private static int[] mapWeights(String equation, int numberOfWeights){
        int[] weights = new int[numberOfWeights];
        int negativeMultiplier = 1; // applied after the = sign is passed
        int mapPos = 0;
        int depth = 0;
        char[] curNumber = new char[10];
        int curPos = 0;
        while (curPos < equation.length()-1){
            while (equation.charAt(curPos) != ' '){
                curNumber[depth++] = equation.charAt(curPos);
                curPos++;
                if (!(curPos < equation.length()-1))
                    break;
            }
            for (int i = 0; i < depth; i++) {
                if (curNumber[i] == '?'){
                    weights[mapPos++] = negativeMultiplier * ((int) pow(10, (depth - i) - 1));
                }
            }
            depth = 0;
            curNumber = new char[10];
            while (equation.charAt(curPos) == ' ' || equation.charAt(curPos) == '+' || equation.charAt(curPos) == '='){
                if (equation.charAt(curPos) == '=')
                    negativeMultiplier = -1;
                curPos++;
            }
        }
        return weights;
    }

    private static int[] parseStringToInt(String numInString){
        int countLocal = 0;
        int sumLocal = 0;
        for (int i = 0; i < numInString.length(); i++) {
            if (numInString.charAt(i) == '?') {
                countLocal++;
            }
            else {
                int value = Integer.parseInt(String.valueOf(numInString.charAt(i)));
                sumLocal += value * pow(10, (numInString.length() - i) -1) ;
            }
        }
        return new int[] {sumLocal, countLocal};
    }
    private static void checkMatchingNumbers(byte[][] permutations, int[] weights, int sum){
        int countMatching = 0;
        for (int i = 0; i < permutations.length; i++) {
            int proposedSum = sum;
            for (int varNumber = 0; varNumber < weights.length; varNumber++) {
                proposedSum += permutations[i][varNumber]*weights[varNumber];
            }
            if (proposedSum == 0){
                System.out.println(Arrays.toString(permutations[i]) + " numbers makes equation true");
                countMatching++;
            }
        }
        if (countMatching == 0){
            System.out.println("There is no numbers that can make this equation to be true");
        }
    }

    // функция честно украдено со стэковерфлоу https://stackoverflow.com/a/73374413, сам не успел осилить
    private static byte[][] generatePermutations(byte positionsNumber) {
        //Array that holds a single permutation, e.g., {0,1,1}
        int count = 0;
        byte[][] permutations = new byte[(int) pow(10, positionsNumber)][positionsNumber];
        byte[] permutation = new byte[positionsNumber];
        do {
            permutations[count] = Arrays.copyOf(permutation,positionsNumber); //permutation - did not work, :monkahmmm:;
            count++;
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