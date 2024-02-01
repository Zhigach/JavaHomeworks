package taskThree;

import java.io.*;

public class SubstituteSymbolInFile {
    public static void substituteChar(String filename, char src, char replacement) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename));
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename+"-new"))) {
            while (br.ready()) {
                char value = (char) br.read();
                if (value == src) {
                    value = replacement;
                }
                bw.write(value);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void substitutePhrase(String filename, String src, String replacement) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename));
             BufferedWriter bw = new BufferedWriter(new FileWriter(filename+"-new2"))) {
            while (br.ready()) {
                String line = br.readLine();
                bw.write(line.replace(src, replacement));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
