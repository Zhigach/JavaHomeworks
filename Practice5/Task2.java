/*
    Пусть дан список сотрудников: task2.in
    Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */

import java.io.*;
import java.util.*;

public class Task2 {
    // cat task2.in | sort | uniq -c
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("task2.in"));

        HashMap<String, Integer> nameCounter = new HashMap<>();

        String line = br.readLine();
        String name;
        while (line != null) {
            name = line.split(" ")[0];
            if (nameCounter.containsKey(name)) {
                nameCounter.put(name, nameCounter.get(name) + 1);
            } else {
                nameCounter.put(name, 1);
            }
            line = br.readLine();
        }

        printMapSortedByValue(nameCounter);
    }

    private static void printMapSortedByValue(HashMap<String, Integer> map) {
        List<NameCounter> valuesList = new ArrayList<>();
        for (String key : map.keySet()) {
            valuesList.add(new NameCounter(key, map.get(key)));
        }
        valuesList.sort(NameCounter::compareTo);
        for (int i = valuesList.size()-1; i >= 0; i--) {
            System.out.printf("Name %s is met %d time(s)\n", valuesList.get(i).value, valuesList.get(i).counter);
        }
    }

    static class NameCounter implements Comparable{
        private int counter = 0;
        String value;
        NameCounter(String name) {value = name; counter = 0;}
        NameCounter(String name, int c) {
            value = name;
            this.counter = c;
        }
        @Override
        public int compareTo(Object o) {
            if (o.getClass() == NameCounter.class)
                return Integer.compare(this.counter, ((NameCounter) o).counter);
            return 0;
        }
    }
}
