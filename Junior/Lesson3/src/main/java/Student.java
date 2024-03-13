import java.io.*;

/*
    Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
    Обеспечьте поддержку сериализации для этого класса.
    Создайте объект класса Student и инициализируйте его данными.
    Сериализуйте этот объект в файл.
    Десериализуйте объект обратно в программу из файла.
    Выведите все поля объекта, включая GPA, и обсудите,
    почему значение GPA не было сохранено/восстановлено.
 */
public class Student implements Serializable {
    String name;
    int age;
    transient double GPA;

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    void serialize(OutputStream outputStream) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    Student deserialize(InputStream inputStream) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            return (Student) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Student {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }
}
