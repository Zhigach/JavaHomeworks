package Practice5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
    Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов
 */
public class Task1 {
    private static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
    static Logger l = Logger.getLogger(Task1.class.getName());


    private static boolean containsString(ArrayList<String> array, String value) {
        return array.contains(value);
    }
    public static void addRecord(String name, String number) {
        if (phoneBook.containsKey(name)) {
            if (!containsString (phoneBook.get(name), number)) {
                phoneBook.get(name).add(number);
                l.info(String.format("Record \"%s: %s\" added", name, number));
            } else {
                l.warning(String.format("Record \"%s: \"%s already exists", name, number));
            }
        } else {
            ArrayList<String> tmp = new ArrayList<>(1);
            tmp.add(number);
            phoneBook.put(name, tmp);
            l.info(String.format("Record \"%s: %s\" added", name, number));
        }
    }

    public static void main(String[] args) throws IOException {
        l.setUseParentHandlers(false);
        FileHandler fh = new FileHandler("task1.log");
        fh.setFormatter(new SimpleFormatter());
        l.addHandler(fh);

        addRecord("Ivanov", "+79101234567");
        addRecord("Petrov", "+79101234567");
        addRecord("Ivanov", "+79101234567");
        addRecord("Ivanov", "+70000000007");
    }

}
