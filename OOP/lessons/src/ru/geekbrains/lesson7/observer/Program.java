package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Program {


    /**
     * TODO: 1.Доработать приложение, поработать с шаблоном проектирования Observer
     *   добавить новый тип соискателя.
     *   **.2 Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     *   **.3 Предусмотреть тип вакансии (enum)
     */
    public static void main(String[] args) {

        JobAgency jobAgency = new JobAgency();

        Company geekBrains = new Company("GeekBrains", 70, jobAgency);
        Company google = new Company("Google", 100, jobAgency);
        Company yandex = new Company("Yandex", 120, jobAgency);

        Master ivanov = new Master("Ivanov");
        Master petrov = new Master("Petrov");
        Student sidorov = new Student("Sidorov");
        EffectiveManager owl = new EffectiveManager("Сова");

        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(sidorov);
        jobAgency.registerObserver(owl);

        Vacancy vacancy;
        for (int i = 0; i < 5; i++){

            vacancy = geekBrains.createVacancy(getRandomDuty());
            geekBrains.publishVacancy(vacancy);

            vacancy = google.createVacancy(getRandomDuty());
            google.publishVacancy(vacancy);

            vacancy = yandex.createVacancy(getRandomDuty());
            yandex.publishVacancy(vacancy);
        }
    }

    static Duties getRandomDuty() {
        Random random = new Random();
        return Duties.values()[random.nextInt(Duties.values().length)];
    }
}
