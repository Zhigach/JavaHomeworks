package ru.geekbrains.lesson3;

public class Worker extends Employee {


    public Worker(String name, String surname, int age, int experience, double baseSalary) {
        super(name, surname, age, experience, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary*8*20 * Math.max(Math.pow(experience, 0.5),1);
    }

    @Override
    public String toString() {
        return String.format("%s %s; %d лет; Стаж %d лет; Рабочий; Месячная заработная плата: %.2f (у.е.)",
                surname, name, age, experience, calculateSalary());
    }
}
