package ru.geekbrains.lesson7.observer;

public class Student extends Worker {

    public Student(String name) {
        super(name, random.nextInt(2, 5) * 1000);
        dutiesSet.add(Duties.KeyBringing);
    }

    @Override
    public String className() {
        return "Студент";
    }

}
