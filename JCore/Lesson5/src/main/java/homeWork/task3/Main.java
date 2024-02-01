package homeWork.task3;

import java.io.File;
import java.nio.file.Files;

/*
Написать функцию, добавляющую префикс к каждому из набора файлов,
 названия которых переданы ей в качестве параметров через пробел.
 */
public class Main {
    /**
     * Simply adds a prefix to a listed files
     * @param files - files must be separated with a space
     * @param prefix - files must be separated with a space
     */
    public static void addPrefix(String files, String prefix) {
        String[] fileNames = files.split(" ");
        for (String fileName : fileNames) {
            if (Files.exists(new File(fileName).toPath())) {
                File file = new File(fileName);
                file.renameTo(new File(prefix + fileName));
            } else {
                System.out.printf("%s doesn't exist. Will be skipped.", fileName);
            }
        }
    }
    public static void main(String[] args) {
        addPrefix("test not_test", "ez_");
    }
}
