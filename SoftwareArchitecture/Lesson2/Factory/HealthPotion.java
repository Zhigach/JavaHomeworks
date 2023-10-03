package SoftwareArchitecture.Lesson2.Factory;

import java.util.Random;

public class HealthPotion implements StoreItem {
    static int counter = 0;
    int id;
    int price;
    int weight;
    String epicName;

    public HealthPotion() {
        Random random = new Random();
        this.price = random.nextInt(1,20);
        this.weight = random.nextInt(50,300);
        this.epicName = String.format("Potion%d", counter);
        id = counter++;
    }
    public HealthPotion(int price, int weight, String epicName) {
        this.price = price;
        this.weight = weight;
        this.epicName = epicName;
    }

    @Override
    public String toString() {
        return String.format("%d: %s, cost %d gold, weight %s g", id, epicName, price, weight);
    }
}
