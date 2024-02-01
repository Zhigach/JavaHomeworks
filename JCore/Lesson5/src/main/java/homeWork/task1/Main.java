package homeWork.task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/*
Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий)
 во вновь созданную папку ./backup
 */
public class Main {
    public static void backupFiles(String path) throws IOException {

        File curdir = new File(path);
        Path backupPath = new File(".backup").toPath();
        boolean backupDirCreated = Files.exists(backupPath);
        for (File file : Objects.requireNonNull(curdir.listFiles())) {
            if (file.isFile()) {
                if (!backupDirCreated) {
                    backupDirCreated = true;
                }
                Files.copy(file.toPath(),
                        new File(backupPath + File.separator + file.getName()).toPath(),
                        REPLACE_EXISTING);
            }
        }

    }
    public static void main(String[] args) {
        try {
            backupFiles(".");
        } catch (IOException e) {
            System.out.println("Got exception " + e.getMessage());
            e.printStackTrace();
        }
    }
}

