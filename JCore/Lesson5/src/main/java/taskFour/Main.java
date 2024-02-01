package taskFour;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public class Main {
    static String separator;
    public static void printDirectoryContent(String outFile) {
        File file = new File(".");
        for (File listFile : Objects.requireNonNull(file.listFiles())) {
            separator = listFile.isDirectory() ? "/" : "";
            System.out.printf(listFile.getName() + (separator) + "\n");
        }
    }
    public static void printDirectoryContentRecursive(String outFile) {
        printDirectoryContentRecursive(outFile, new File("."), "");
    }
    private static void printDirectoryContentRecursive(String outFile, File path, String indent) {
        for (File listFile : Objects.requireNonNull(path.listFiles())) {
            separator = listFile.isDirectory() ? "/" : "";
            if (listFile.isDirectory()) {
                System.out.printf(indent + listFile.getName() + (separator) + "\n");
                indent += "  ";
                printDirectoryContentRecursive("", listFile.toPath().toFile(), indent);
            } else {
                System.out.printf(indent + listFile.getName() + (separator) + "\n");
            }
        }
    }
    public static void main(String[] args) {
        //printDirectoryContent("");
        printDirectoryContentRecursive("");
    }
}
