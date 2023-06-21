package ru.geekbrains.lesson7.observer;

import java.util.HashSet;
import java.util.Set;

public class Master extends Worker{
    public Master(String name) {
        super(name, random.nextInt(80, 100) * 1000);
        dutiesSet.add(Duties.Development);
        dutiesSet.add(Duties.Deployment);
    }

    public String className() {
        return "Мастер";
    }
}
