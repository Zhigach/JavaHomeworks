package Practice4;

import java.util.LinkedList;
import java.util.Random;

/*
    Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
 */
public class Task1 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = createRandimLinkedList(10, 0, 10);
        System.out.printf("Initial list: %s\n",linkedList);
        reverseLinkedList(linkedList);
        System.out.printf("Reversed list: %s\n", linkedList);
    }

    private static LinkedList<Integer> createRandimLinkedList(int size, int lowerBound, int upperBound) {
        Random random = new Random();
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < size; i++)
            result.add(random.nextInt(lowerBound, upperBound));
        return result;
    }

    private static void reverseLinkedList(LinkedList<Integer> linkedList) {
        LinkedList<Integer> buffer = new LinkedList<>();
        buffer.addAll(linkedList);
        linkedList.clear();
        for (int i = buffer.size() - 1; i >= 0 ; i--) {
            linkedList.push(buffer.pop());
        }
    }
}
