package ru.geekbrains.lesson4;

import java.util.ArrayList;

public class Box<T extends Fruit>{
    private ArrayList<T> box;

    public Box () {
        this.box = new ArrayList<>();
    }
    public Box(ArrayList<T> box) {
        this.box = box;
    }

    /**
     * Method moves all Fruits from a container to a current box
     * @param donorBox - box from where we will take Fruits
     */
    public void takeFromBox(Box<T> donorBox) {
        this.box.addAll(donorBox.box);
        donorBox.box.clear();
    }
    public void addFruit(T e) {
        this.box.add(e);
    }

    public float getWeight() {
        return box.size() * box.get(0).getWeight();
    }

    public int getQuantity() {
        return box.size();
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }
}
