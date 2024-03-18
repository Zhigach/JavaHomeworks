package ru.geekbrains;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.config.ProjectConfigurator;
import ru.geekbrains.domain.Car;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfigurator.class);

        Car sampleCar = context.getBean("patrik", Car.class);
        System.out.println(sampleCar);

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer integer = context.getBean(Integer.class);
        System.out.println(integer);
    }
}
