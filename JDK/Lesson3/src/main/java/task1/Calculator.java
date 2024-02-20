package task1;

import java.security.Key;

/**
 * Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
 * sum(), multiply(), divide(), subtract().
 * Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
 */
public class Calculator {
    public static <T extends Number> T sum(T t, T k) {
        if (t instanceof Integer) {
            return (T) Integer.valueOf(t.intValue() + k.intValue());
        } else if (t instanceof Double) {
            return (T) Double.valueOf(t.doubleValue() + k.doubleValue());
        } else {
            throw new IllegalArgumentException("Illegal arguments provided");
        }
    }
}
