package ru.geekbrains.lesson7.observer;

import java.util.Arrays;
import java.util.Random;

public class Vacancy {
    int proposedSalary;
    Duties demandedDuties;

    public Vacancy(int proposedSalary, Duties demandedDuties) {
        this.proposedSalary = proposedSalary;
        this.demandedDuties = demandedDuties;
    }

    public Vacancy createVacancy(int lowerSalary, int upperSalary) {
        Random random = new Random();
        return new Vacancy(random.nextInt(lowerSalary, upperSalary)*1000, Duties.Development);
    }
}
