package Practice2;

/*
3.* В файле содержится строка с данными:
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Task3 {
    public static void main(String[] args) throws IOException {
        String inputStr = readFile("t3-input.txt");
        String[] jsonArray = inputStr.split(", ");
        printReport(createReport(jsonArray));
    }

    public static String readFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String result = br.readLine();
        result = result.substring(1, result.length()-1);
        return result;
    }

    public static void printReport(String[] report){
        for (String str : report) {
            System.out.println(str);
        }
    }

    public static String[] createReport(String[] studentsInfoArray){
        String[] result = new String[studentsInfoArray.length];
        String template = "Студент <LN> получил <M> по предмету <DISC>.";
        int count = 0;
        for (String studentInfo : studentsInfoArray) {
            String newRecord = String.copyValueOf(template.toCharArray());
            String[] keyValueArray = studentInfo.split(",");
            String lastName = keyValueArray[0].split(":")[1];
            String mark = keyValueArray[1].split(":")[1];
            String discipline = keyValueArray[2].split(":")[1];
            newRecord = newRecord.replace("<LN>", lastName.substring(1,lastName.length()-1));
            newRecord = newRecord.replace("<M>", mark.substring(1,mark.length()-1));
            newRecord = newRecord.replace("<DISC>", discipline.substring(1,discipline.length()-1));
            result[count++] = newRecord;
        }
        return result;
    }

}
