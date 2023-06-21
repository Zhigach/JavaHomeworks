package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Company {

    private static final Random random = new Random();
    private final String nameCompany;
    private final int maxSalary;

    private final Publisher jobAgency;

    public Company(String nameCompany, int maxSalary, Publisher jobAgency) {
        this.nameCompany = nameCompany;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
    }

    /**
     * Create new vacancy for the company
     */
    Vacancy createVacancy(Duties duty) {
        int salary = random.nextInt(1, maxSalary) * 1000;
        Vacancy vacancy = new Vacancy(nameCompany, salary, duty);
        this.publishVacancy(vacancy);
        return vacancy;
    }

    public void publishVacancy(Vacancy vacancy) {
        System.out.printf("\n%s >>> New vacancy available!\n\t%s\n", nameCompany, vacancy);
        needEmployee(vacancy);
    }
    public void needEmployee(Vacancy vacancy){
        jobAgency.sendOffer(vacancy);
    }

}
