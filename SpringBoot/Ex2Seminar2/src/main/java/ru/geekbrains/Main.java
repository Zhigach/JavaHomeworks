package ru.geekbrains;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.config.ProjectConfigurator;
import ru.geekbrains.domain.Car;
import ru.geekbrains.domain.Engine;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfigurator.class);

        Car car = context.getBean(Car.class);
        Car car2 = context.getBean(Car.class);
        System.out.println(car);

        Engine engine = context.getBean(Engine.class);
        System.out.println(engine);
    }
}
