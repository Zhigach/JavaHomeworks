package ru.geekbrains.lesson7.observer;

import java.util.ArrayList;
import java.util.List;

public class JobAgency implements Publisher {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.print("Successfully registered: ");
        observer.printInfo();
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void sendOffer(Vacancy vacancy) {
        for (Observer observer: observers) {
            if (observer.getDutiesSet().contains(vacancy.requestedDuties)) {
                observer.receiveOffer(vacancy);
            } else {
                System.out.printf("Not sending %s to %s\n", vacancy, observer);
            }
        }
    }
}
