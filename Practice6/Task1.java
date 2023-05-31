/*
    Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
    Создать множество ноутбуков.
    Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
    “Введите цифру, соответствующую необходимому критерию:
    1 - ОЗУ
    2 - Объём ЖД
    3 - Операционная система
    4 - Цвет …
    Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
    Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */

import java.util.*;

public class Task1 {
    static List<Notebook> nbList = new ArrayList<>(10);
    static public void printFiltered(HashMap<Integer, String> keysValuesMap) {//int[] keys, Object minValue) {
        HashSet<Notebook> results = new HashSet<>();
        for (Notebook nb: nbList) {
            boolean isMatching = true;
            for (Integer key: keysValuesMap.keySet()) {
                if (key < 3 && nb.getValue(key) < Integer.parseInt(keysValuesMap.get(key))) {
                    isMatching = false;
                    break;
                }
                if (key > 2 && !Objects.equals(nb.getStringParam(key), keysValuesMap.get(key))) {
                    isMatching = false;
                    break;
                }
            }
            if (isMatching)
                results.add(nb);
        }
        int i = 1;
        for (Notebook nb: results) {
            System.out.printf("%d: ", i++);
            System.out.printf("%s GB RAM, %s GB Hard drive, Operational system - %s, %s\n", nb.getRam(), nb.getDisk_space(), nb.getOs(), nb.getColor());
        }
        if (results.size() == 0) {
            System.out.println("No notebooks matching your request found.");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        nbList.add(new Notebook(8, 512, "No", "Black"));
        nbList.add(new Notebook(8, 1024, "Windows", "Black"));
        nbList.add(new Notebook(16, 1024, "Windows", "Blue"));
        nbList.add(new Notebook(32, 1024, "MacOS", "Silver"));
        nbList.add(new Notebook(64, 2048, "Linux", "Black"));

        HashSet<String> osSet = new HashSet<>();
        HashSet<String> colorsSet = new HashSet<>();
        for (Notebook entry:nbList) {
            osSet.add(entry.getOs());
            colorsSet.add(entry.getColor());
        }
        LinkedHashMap<Integer, String> filters = new LinkedHashMap<>() {{
            put(1, "RAM");
            put(2, "Hard drive capacity");
            put(3, "OS");
            put(4, "Color");
        }};

        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("We have some notebooks...\nChoose characteristic to filter them (use space bar to pass multiple parameters) or enter 0 to exit:");
            for (Integer key : filters.keySet()) {
                System.out.printf("%d - %s\n", key, filters.get(key));
            }

            do {
                choice = scanner.nextLine();
            } while (choice.length() == 0);

            if (choice.equals("0")) {
                System.out.println("Program will exit now.");
                break;
            }
            HashMap<Integer, String> filterOptions = new HashMap<>();
            int value;
            for (String key : choice.split(" ")) {
                if (Integer.parseInt(key.strip()) > filters.size()) {
                    System.out.println("Incorrect value. Try again.");
                    continue;
                }
                if (Integer.parseInt(key.strip()) < 3) {
                    System.out.printf("Specify minimum value of the %s for notebook you are searching:", filters.get(Integer.parseInt(key)));
                    value = scanner.nextInt();
                    filterOptions.put(Integer.parseInt(key), String.valueOf(value));
                    System.out.println();
                } else if (filters.get(Integer.parseInt(key)).equals("OS")) {
                    System.out.printf("Specify value of the %s for notebook you are searching. Can be: %s\n", filters.get(Integer.parseInt(key)), Arrays.toString(osSet.toArray()));
                    String stringParameter = scanner.next();
                    filterOptions.put(Integer.parseInt(key), stringParameter);
                    System.out.println();
                } else {
                    System.out.printf("Specify value of the %s for notebook you are searching. Can be: %s\n", filters.get(Integer.parseInt(key)), Arrays.toString(colorsSet.toArray()));
                    String stringParameter = scanner.next();
                    filterOptions.put(Integer.parseInt(key), stringParameter);
                    System.out.println();
                }
            }
            printFiltered(filterOptions);
        } while (true);

    }
}
