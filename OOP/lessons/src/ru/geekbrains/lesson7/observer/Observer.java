package ru.geekbrains.lesson7.observer;

import java.util.Random;

public interface Observer {

    static Random random = new Random();

    void receiveOffer(String nameCompany, int salary);
}
