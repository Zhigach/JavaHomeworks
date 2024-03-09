import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    Задача 1:
    Создайте абстрактный класс "Animal" с полями "name" и "age".
    Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
    Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
    Выведите на экран информацию о каждом объекте.
    Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */
public class Task1 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Animal[] animals = {
                new Dog(5, "Alfa", "woof"),
                new Cat(10, "King", "meoow"),
                new Dog(11, "Ace","wav"),
                new Cat(100500, "Player","mp3")
        };
        for (Animal animal : animals) {
            Method[] methods = animal.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals("makeSound")) {
                    method.invoke(animal);
                }
            }
        }
    }
}
