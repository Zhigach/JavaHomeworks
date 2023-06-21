package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Vacancy {
    String companyName;
    int proposedSalary;

    Duties requestedDuties;

    public Vacancy(String companyName, int proposedSalary, Duties requestedDuties) {
        this.companyName = companyName;
        this.proposedSalary = proposedSalary;
        this.requestedDuties = requestedDuties;
    }

    /**
     * Create random duty vacancy within specified salary bounds
     * @param lowerSalary lower salary bound in thousands
     * @param upperSalary upper salary bound in thousands
     */
    public static Vacancy createVacancy(int lowerSalary, int upperSalary) {
        Random random = new Random();
        return new Vacancy("companyName_"+random.nextInt(100), random.nextInt(lowerSalary, upperSalary)*1000, Duties.values()[random.nextInt(Duties.values().length)]);
    }

    @Override
    public String toString() {
        return String.format("%s for %d", requestedDuties, proposedSalary);
    }
}
