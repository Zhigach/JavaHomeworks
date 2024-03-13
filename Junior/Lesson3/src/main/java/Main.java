import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Ivan", 99, 2.25);
        System.out.println(student);
        try (FileOutputStream fileOutputStream = new FileOutputStream("serial_student.txt")) {
            student.serialize(fileOutputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileInputStream fileInputStream = new FileInputStream("serial_student.txt")) {
            Student studentFromRecord = student.deserialize(fileInputStream);
            System.out.println(studentFromRecord); // GPA is not read as it is marked as @transient
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to read record");
        }

    }
}
