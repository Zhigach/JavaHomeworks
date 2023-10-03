package SoftwareArchitecture.Lesson2.Factory;

import java.util.Random;

public class Weapon  implements StoreItem{
    static int counter = 0;
    int id;
    int price;
    int weight;
    String epicName;

    public Weapon() {
        Random random = new Random();
        this.price = random.nextInt(10,100);
        this.weight = random.nextInt(1,5);
        this.epicName = String.format("Weapon%d", counter);
        id = counter++;
    }
    public Weapon(int price, int weight, String epicName) {
        this.price = price;
        this.weight = weight;
        this.epicName = epicName;
    }

    @Override
    public String toString() {
        return String.format("%d: %s, cost %d gold, weight %s kg", id, epicName, price, weight);
    }
}
