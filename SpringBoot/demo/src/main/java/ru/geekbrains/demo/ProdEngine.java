package ru.geekbrains.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class ProdEngine implements Engine{
    public ProdEngine() {
        System.out.println("Engine started on production.");
    }

    @Override
    public void go() {
        System.out.println("Go fast!");
    }
}
