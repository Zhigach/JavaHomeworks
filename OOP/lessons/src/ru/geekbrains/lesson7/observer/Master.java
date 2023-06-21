package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Master implements Observer {
    private String name;

    private int minSalary;

    public Master(String name) {
        this.name = name;
        minSalary = random.nextInt(80, 100) * 1000;
    }

    @Override
    public void receiveOffer(String nameCompany, int salary) {
        if (minSalary <= salary){
            System.out.printf("Мастер %s (%d) >>> Мне нужна эта работа! (%s - %d)\n",
                    name, minSalary, nameCompany, salary);
            minSalary = salary;
        }
        else{
            System.out.printf("Мастер %s (%d) >>> Я найду работу получше! (%s - %d)\n",
                    name, minSalary, nameCompany, salary);
        }
    }

}
