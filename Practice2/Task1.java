/*
В файле содержится строка с исходными данными в такой форме:
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Task1 {
    public static void main(String[] args) throws IOException {

        String inputStr = readFile("t1-input.txt");
        inputStr = inputStr.substring(1, inputStr.length()-1);
        System.out.println(convertToSQL("students", inputStr.split(",")));
    }

    public static String readFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String result = br.readLine();
        return result;
    }

    public static String convertToSQL(String dbName, String[] keyValueArray){
        StringBuilder result = new StringBuilder("SELECT * FROM ");
        result.append(dbName).append(" WHERE");
        for (String str : keyValueArray) {
            str = str.strip();
            String[] keyValue = str.split(":");
            if (keyValue[1].equals("\"null\"")){
                continue;
            }
            result.append(" ")
                    .append(keyValue[0].substring(1, keyValue[0].length() - 1))
                    .append(" = ").append(keyValue[1])
                    .append(" AND");
        }
        result = new StringBuilder(result.substring(0, result.length() - 4));
        return result.toString();
    }
}
