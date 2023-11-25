import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//import ListComparator;

class ListComparatorTest {
    IntArray arr = new IntArray(new int[]{1, 2, 3, 4, 5});
    IntArray arr2 = new IntArray(new int[]{1, 2, 3, 4, 5});
    IntArray arr3 = new IntArray(new int[]{0, 2, 0, 4, 5});

    @org.junit.jupiter.api.Test
    void compareListsFirstOneGreater() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        ListComparator.compareLists(arr, arr3);
        String result = baos.toString();
        System.setOut(stdout);
        assertEquals("Первый список имеет большее среднее значение\n", result);
    }
    @org.junit.jupiter.api.Test
    void compareListsSecondOneGreater() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        ListComparator.compareLists(arr3, arr);
        String result = baos.toString();
        System.setOut(stdout);
        assertEquals("Второй список имеет большее среднее значение\n", result);
    }
    @org.junit.jupiter.api.Test
    void compareListsEquals() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        ListComparator.compareLists(arr, arr2);
        String result = baos.toString();
        System.setOut(stdout);
        assertEquals("Средние значения равны\n", result);
    }
}