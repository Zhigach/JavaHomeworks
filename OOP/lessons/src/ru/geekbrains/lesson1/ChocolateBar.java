package ru.geekbrains.lesson1;

public class ChocolateBar extends  Product{
    private final int cocoaContains;
    ChocolateBar(String brand, String name, double price, int cocoaContains) {
        super(brand, name, price);
        this.cocoaContains = cocoaContains;
    }

    public int getCocoaContains() {
        return cocoaContains;
    }

    @Override
    public String displayInfo() {
        return  String.format("[Шоколад] %s - %s - %f руб - %d%% какао", name, brand, price, cocoaContains);
    }
}
