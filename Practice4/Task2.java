import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
    Реализуйте очередь с помощью LinkedList со следующими методами:
    enqueue() - помещает элемент в конец очереди,
    dequeue() - возвращает первый элемент из очереди и удаляет его,
    first() - возвращает первый элемент из очереди, не удаляя.
 */
public class Task2 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue = createRandomQueue(5, 0, 10);
        System.out.printf("Initial queue: %s\n", queue);
        queue.enqueue(5);
        System.out.printf("Enqueue demo, pushing 5: %s\n", queue);
        System.out.printf("Dequeue demo: first queue element %s, new queue %s\n", queue.dequeue(), queue);
        System.out.printf("First queue element: %s\n", queue.first());
    }
    static class Queue<E> extends LinkedList{

        public void enqueue(Object item) {
            super.add(item);
        }
        public Object dequeue() {
            return super.pop();
        }
        public Object first() {
            return super.getFirst();
        }
    }

    private static Queue<Integer> createRandomQueue(int size, int lowerBound, int upperBound) {
        Random random = new Random();
        Queue<Integer> result = new Queue<>();
        for (int i = 0; i < size; i++)
            result.add(random.nextInt(lowerBound, upperBound));
        return result;
    }
}
