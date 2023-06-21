package ru.geekbrains.lesson7.adapter;

public class Program {

    public static void main(String[] args) {

        MS200 ms200 = new MS200(15);
        ST500Info st500Info = new ST500Info(55);
        MeteoStore meteoStore = new MeteoStore();
        meteoStore.save(ms200);
        meteoStore.save(new AdapterST500Info(st500Info));

    }

}
