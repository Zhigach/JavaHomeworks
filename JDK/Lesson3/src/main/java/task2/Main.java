package task2;

import static task2.ArraysComparator.compareArrays;

public class Main {
    public static void main(String[] args) {
        Integer[] intOne = {1, 2, 3, 4, 5};
        Integer[] intTwo = {1, 2, 3, 4};

        String[] strOne = {"One", "Two", "Three"};
        String[] strTwo = {"One", "Two", "Three"};
        String[] strThree = {"Zero", "One", "Two"};

        System.out.println(compareArrays(intOne, intTwo));
        System.out.println(compareArrays(intOne,strOne));
        System.out.println(compareArrays(strOne, strTwo));
        System.out.println(compareArrays(strTwo, strThree));

    }
}
