/*
    Пусть дан список сотрудников: task2.in
    Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */

import java.io.*;
import java.util.HashMap;

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

        System.out.println(nameCounter.toString());
    }
}
