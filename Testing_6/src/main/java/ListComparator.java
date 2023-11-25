import java.util.ArrayList;
import java.util.List;

/*
Задание 1. Создайте программу на Python или Java, которая принимает два списка чисел и выполняет следующие действия:
a. Рассчитывает среднее значение каждого списка.
b. Сравнивает эти средние значения и выводит соответствующее сообщение:
- ""Первый список имеет большее среднее значение"", если среднее значение первого списка больше.
- ""Второй список имеет большее среднее значение"", если среднее значение второго списка больше.
- ""Средние значения равны"", если средние значения списков равны.

Важно:
Приложение должно быть написано в соответствии с принципами объектно-ориентированного программирования.
Используйте Pytest (для Python) или JUnit (для Java) для написания тестов, которые проверяют правильность работы программы. Тесты должны учитывать различные сценарии использования вашего приложения.
Используйте pylint (для Python) или Checkstyle (для Java) для проверки качества кода.
Сгенерируйте отчет о покрытии кода тестами. Ваша цель - достичь минимум 90% покрытия.


*Формат и требования к сдаче: *
Отчет о выполнении этого задания должен включать в себя следующие элементы:
- Код программы
- Код тестов
- Отчет pylint/Checkstyle
- Отчет о покрытии тестами
- Объяснение того, какие сценарии покрыты тестами и почему вы выбрали именно эти сценарии.
 */
public class ListComparator {
    public static void compareLists(int[] first, int[] second) {
        int result = compareListsCalculator(first, second);
        switch (result){
            case 1 -> System.out.println("Первый список имеет большее среднее значение");
            case 2 -> System.out.println("Второй список имеет большее среднее значение");
            default -> System.out.println("Средние значения равны");
        }
    }

    private static int compareListsCalculator(int[] first, int[] second) {
        if (calcAverage(first) > calcAverage(second))
            return 1;
        if (calcAverage(second) > calcAverage(first))
            return 2;
        return 0;
    }

    private static double calcAverage(int[] arr) {
        int summ = 0;
        for (int number : arr) {
            summ += number;
        }
        return (double) summ /arr.length;
    }
}
