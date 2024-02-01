package homeWork.task2;
/*
Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой, например,
 состояния ячеек поля для игры в крестики-нолики,
  где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом, 3 – резервное значение.
   Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
    Записать в файл 9 значений так, чтобы они заняли три байта.
 */

import java.io.*;
import java.util.HexFormat;

public class Main {
    static byte[] field = new byte[9];
    public static void printField (byte[] field) {
        System.out.println("- - - - - -");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                System.out.printf("%d ", field[3*i + j]);
            }
            System.out.println();
        }
        System.out.println("- - - - - -");
    }

    public static void printFieldCompressed() {
        try ( DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("field.txt")) ){
            for (int i = 0; i < 3; i++) {
                byte value = 0;
                for (int j = 0; j < 3; j++){
                    value += (byte) (field[3*i+j] << 2*j);
                }
                dataOutputStream.writeByte(value);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] readFieldCompressed() {
        try ( DataInputStream dataInputStream = new DataInputStream(new FileInputStream("field.txt")) ){
            byte[] result = new byte[9];
            for (int i = 0; i < 3; i++) {
                byte value = dataInputStream.readByte();
                for (int j = 0; j < 3; j++) {
                    result[3*i+j] = (byte) ((value & (byte) (Math.pow(2,2*j+1) + Math.pow(2,2*j))) >> j*2);
                }
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        field = new byte[]{3, 0, 1, 1, 1, 1, 1, 2, 1};
        printField(field);
        printFieldCompressed();
        printField(readFieldCompressed());
    }
}
