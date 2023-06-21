package ru.geekbrains.lesson7.observer;

public class EffectiveManager extends Worker{
    public EffectiveManager(String name) {
        super(name, random.nextInt(150, 300) * 1000);
        dutiesSet.add(Duties.VisionOfWorking);
    }

    @Override
    public String className() {
        return "Эффективный менеджер";
    }
}
