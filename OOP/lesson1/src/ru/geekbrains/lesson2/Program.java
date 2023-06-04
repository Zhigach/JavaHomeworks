package ru.geekbrains.lesson2;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Belka", 1, 3),
                new Cat("Barsik", 5, 25),
                new Cat("Gav", 10, 30)
        };

        Plate plate = new Plate(100);

        plate.info();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (Cat cat : cats) {
                cat.eat(plate);
                cat.info();
            }
            plate.info();
            System.out.println("Cats have eaten some food. Do you want to add some more (Y/N/any to exit)?");
            String choice = scanner.next();
            if (choice.equals("Y") ) {
                System.out.println("How much food do you wish to add?");
                plate.addFood(scanner.nextInt());
            } else if (choice.equals("N")) {
                System.out.println("Cats will eat the rest food");
            } else {
                System.out.println("Exiting");
                break;
            }
        }

    }
}
