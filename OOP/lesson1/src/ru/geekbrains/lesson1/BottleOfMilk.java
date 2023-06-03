package ru.geekbrains.lesson1;

public class BottleOfMilk extends Product {

    private double volume; // объем
    private int fatContent; // Содержание жирности


    public double getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getFatContent() {
        return fatContent;
    }

    public void setFatContent(int fatContent) {
        this.fatContent = fatContent;
    }

    public BottleOfMilk(String brand, String name, double price, double volume, int fatContent) {
        super(brand, name, price);
        this.volume = volume;
        this.fatContent = fatContent;
    }

    @Override
    public String displayInfo() {
        return String.format("[Бутылка] %s - %s - %f [объем: %f; жирность: %d]", brand, name, price, volume, fatContent);
    }
}
