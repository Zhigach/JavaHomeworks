package ru.geekbrains.lesson2;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void info() {
        System.out.printf("Plate contains: %s of food\n", food);
    }
    public void addFood(int food) {
        this.food += food;
        info();
    }
    private void setFood(int food) {
        this.food = food;
    }
    public boolean giveFood(int food) {
        if (food > 0) {
            this.setFood(this.food - food);
            return true;
        }
        else
            return false;
    }

    public int getFood() {
        return this.food;
    }
}