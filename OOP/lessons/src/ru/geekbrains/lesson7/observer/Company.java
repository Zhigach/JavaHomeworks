package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Company {

    private static final Random random = new Random();
    private final String nameCompany;
    private int maxSalary;

    private final Publisher jobAgency;

    public Company(String nameCompany, int maxSalary, Publisher jobAgency) {
        this.nameCompany = nameCompany;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
    }

    public void needEmployee(){
        int salary = random.nextInt(2, 150) * 1000;
        jobAgency.sendOffer(nameCompany, salary);
    }

}
