package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Student implements Observer {

    private final String name;

    private int minSalary;

    public Student(String name) {
        this.name = name;
        minSalary = random.nextInt(2, 5) * 1000;
    }

    @Override
    public void receiveOffer(String nameCompany, int salary) {
        if (minSalary <= salary){
            System.out.printf("Студент %s (%d) >>> Мне нужна эта работа! (%s - %d)\n",
                    name, minSalary, nameCompany, salary);
            minSalary = salary;
        }
        else{
            System.out.printf("Студент %s (%d) >>> Я найду работу получше! (%s - %d)\n",
                    name, minSalary, nameCompany, salary);
        }
    }
}
