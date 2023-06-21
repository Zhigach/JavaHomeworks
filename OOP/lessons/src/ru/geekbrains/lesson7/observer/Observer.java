package ru.geekbrains.lesson7.observer;

import java.util.Random;
import java.util.Set;

public interface Observer {

    Random random = new Random();

    Set<Duties> getDutiesSet();

    String getName();

    int getMinSalary();

    String className();

    void setMinSalary(int newSalary);

    void printInfo();

    default void receiveOffer(Vacancy vacancy) {
        if (getMinSalary() <= vacancy.proposedSalary){
            System.out.printf("%s %s (min: %d) >>> Мне нужна эта работа! (%s - %d)\n",
                    className(), getName(), getMinSalary(), vacancy.companyName, vacancy.proposedSalary);
            setMinSalary(vacancy.proposedSalary);
        } else{
            System.out.printf("%s %s (min: %d) >>> Я найду работу получше! (%s - %d)\n",
                    className(), getName(), getMinSalary(), vacancy.companyName, vacancy.proposedSalary);
        }
    }
}
