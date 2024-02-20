package task3;

import java.nio.charset.StandardCharsets;

/**
 * Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
 * Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
 * а также переопределение метода toString(), возвращающее строковое представление пары.
 */
public class Pair<T,K> {
    T firstComponent;
    K secondComponent;

    public Pair(T first, K second) {
        this.firstComponent = first;
        this.secondComponent = second;
    }

    public T getFirst() {
        return firstComponent;
    }
    public K getSecond() {
        return secondComponent;
    }

    @Override
    public String toString() {
        return String.format("[%s : %s]", firstComponent.toString(), secondComponent.toString());
    }
}
