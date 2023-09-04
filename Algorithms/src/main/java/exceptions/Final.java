package src.main.java.exceptions;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
Фамилия Имя Отчество номертелефона

Форматы данных:
фамилия, имя, отчество - строки
номертелефона - целое беззнаковое число без форматирования

Ввод всех элементов через пробел

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><номер_телефона>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */
public class Final {

    public static void main(String[] args) throws Exception {

        String[] entities;// = new String[1];
        do {
            String input = getNonEmptyString("Введите [Фамилию Имя Отчество Номер_телефона], разделенные пробелами: ");
            entities = splitString(input, 4);
        } while (entities.length == 1);

        try {
            String[] names = getNames(entities);
            PersonRecord personRecord = new PersonRecord(names[0], names[1], names[2],getInt(entities, 3));
            createRecord(personRecord);
        } catch (NumberFormatException nfe) {
            System.out.printf("Телефон указан в неверном формате: %s", nfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(Arrays.toString(ioe.getStackTrace()));
        }

    }


    private static void createRecord(PersonRecord personRecord) throws IOException {
        String extension = ".txt";
        File file = new File(personRecord.surname + extension);
        if (file.createNewFile()) {
            System.out.printf("Новый файл для записей создан: %s", personRecord.surname+extension);
        } else {

            System.out.printf("Пишем в существующий файл: %s", personRecord.surname+extension);
        }
        FileWriter fileWriter = new FileWriter(file, true);
        String payload = String.join(" " ,
                personRecord.surname,
                personRecord.name,
                personRecord.fatherName,
                Integer.toString(personRecord.phoneNumber),
                "\n");
        fileWriter.write(payload);
        fileWriter.close();
    }

    public static String getNonEmptyString(String message) throws Exception {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        if (!Objects.equals(res, "")) {
            return res;
        } else {
            throw new Exception("Method does not support empty strings");
        }
    }

    public static String[] getNames(String[] input){
        return Arrays.copyOfRange(input, 0, 3);
    }

    public static int getInt(String[] input, int pos){
        return Integer.parseInt(input[pos]);
    }

    /**
     * Methods splits string by space symbol and returns length = 1 array if number of entities is incorrect
     * @param str input string
     * @param entitiesNumber expected number of entities
     * @return array of input entities
     */
    public static String[] splitString(String str, int entitiesNumber) {
        String[] result = str.split(" ");
        if (result.length != entitiesNumber) {
            return new String[1];
        } else {
            return result;
        }
    }

    static class PersonRecord {
        String surname;
        String name;
        String fatherName;
        int phoneNumber;

        public PersonRecord(String surname, String name, String fatherName, int phoneNumber) {
            this.surname = surname;
            this.name = name;
            this.fatherName = fatherName;
            this.phoneNumber = phoneNumber;
        }
    }

}
