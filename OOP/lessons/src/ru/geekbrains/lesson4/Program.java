package ru.geekbrains.lesson4;

public class Program {
    /* TODO:
    a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
    b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
    поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
    c. Для хранения фруктов внутри коробки можно использовать ArrayList;
    d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
    вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
    e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
    подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
    Можно сравнивать коробки с яблоками и апельсинами;
    f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
    Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
    Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
    g. Не забываем про метод добавления фрукта в коробку.
     */
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple("RU"));



        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple("RU"));
        appleBox2.addFruit(new Apple("BY"));

        System.out.printf("В ящике откуда пересыпали яблоки сейчас %d фруктов\n", appleBox2.getQuantity());
        appleBox1.takeFromBox(appleBox2);
        System.out.printf("В ящике откуда пересыпали яблоки осталось %d фруктов\n", appleBox2.getQuantity());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange("EGYPT"));
        orangeBox.addFruit(new Orange("EGYPT"));
        orangeBox.addFruit(new Orange("UAR"));

        System.out.printf("В ящике с апельсинами %f условных единиц массы фруктов\n", orangeBox.getWeight());

        //Try to add oranges to apple box
        //appleBox2.takeFromBox(orangeBox); - compiler prohibits such actions (/)

    }
}
