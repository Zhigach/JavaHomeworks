package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class EffectiveManager implements Observer{
    Duties duties;
    String name;
    int minSalary;
    public EffectiveManager(String name) {
        this.name = name;
        minSalary = random.nextInt();
    }
    @Override
    public void receiveOffer(String nameCompany, int salary) {
        if (minSalary <= salary){
            System.out.printf("Эффективный менеджер %s (%d) >>> Мне нужна эта работа! (%s - %d)\n",
                    name, minSalary, nameCompany, salary);
            minSalary = salary;
        }
        else{
            System.out.printf("Эффективный менеджер %s (%d) >>> Я найду работу получше... (%s - %d)\n",
                    name, minSalary, nameCompany, salary);
        }
    }
}
