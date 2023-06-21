package ru.geekbrains.lesson7.observer;

import java.util.HashSet;
import java.util.Set;

public abstract class Worker implements Observer{

    private final String name;

    private int minSalary;

    Set<Duties> dutiesSet;

    protected Worker(String name, int minSalary) {
        this.name = name;
        this.minSalary = minSalary;
        dutiesSet = new HashSet<>();
    }

    @Override
    public int getMinSalary() {
        return minSalary;
    }

    @Override
    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public String getName() {
        return name;
    }

    public Set<Duties> getDutiesSet() {
        return dutiesSet;
    }

    public void printInfo() {
        System.out.printf("%s %s: Duties: %s, desired salary - %d\n", className(), name, getDutiesSet(), getMinSalary());
    }

    @Override
    public String toString() {
        return String.format("%s %s", className(), getName());
    }
}
