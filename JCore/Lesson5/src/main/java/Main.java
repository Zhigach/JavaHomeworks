import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {1,2,3,4,5,6,7,8,9};

        try (DataOutputStream bw = new DataOutputStream(new FileOutputStream("out2.txt"))) {
            //bw.write(Arrays.toString(intArray));
            for (int i : intArray) {
                bw.writeByte(i);
                bw.writeByte(0);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("out2.txt"))) {

            byte[] bytes = dis.readAllBytes();
            int[] filteredArray =
                    IntStream.range(0, bytes.length).map(i -> bytes[i] & 0xFF).filter(i -> i != 0).toArray();
            System.out.println(Arrays.toString(filteredArray));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
