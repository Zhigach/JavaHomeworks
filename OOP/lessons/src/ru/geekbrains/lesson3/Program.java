package lessons.src.ru.geekbrains.lesson3;

import java.util.Arrays;
import java.util.Random;

public class Program {

    static Random random = new Random();

    /**
     * TODO: Переработать метод generateEmployee в рамках домашнего задания,
     *  метод должен генерировать рабочих (Employee) разных типов.
     * @return
     */
    static Employee generateEmployee(){
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

        switch (random.nextInt(1, 3)) {
            case 1 -> {
                int age = random.nextInt(20, 50);
                return new Worker(
                        names[random.nextInt(names.length)],
                        surnames[random.nextInt(surnames.length)],
                        age,
                        random.nextInt(0, (age - 20)),
                        random.nextInt(5, 8));
            }
            case 2 -> {
                int age = random.nextInt(25, 40);
                return new Security(
                        names[random.nextInt(names.length)],
                        surnames[random.nextInt(surnames.length)],
                        age,
                        random.nextInt(0, (age - 25)),
                        random.nextInt(3, 4));
            }
            default -> {
                int age = random.nextInt(0, 10);
                return new Worker(names[random.nextInt(names.length)],
                        surnames[random.nextInt(surnames.length)],
                        age,
                        random.nextInt(0, age),
                        random.nextInt(5, 8));
            }
        }


    }


    /**
     * TODO: Придумать новые состояния для наших сотрудников
     *  Придумать несколько Comparator'ов для сортировки сотрудников
     *  по фамилии + имени или по возрасту и уровню ЗП.
     * @param args
     */
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++){
            employees[i] = generateEmployee();
        }

        Arrays.sort(employees); // new SalaryComparator()

        for(Employee employee : employees){
            System.out.println(employee);
        }

    }

}
