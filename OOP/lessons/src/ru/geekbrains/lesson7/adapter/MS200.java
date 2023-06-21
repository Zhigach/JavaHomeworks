package ru.geekbrains.lesson7.adapter;

public class MS200 implements MeteoSensor {

    private int id;

    public MS200(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getTemperature() {
        return 33;
    }

    @Override
    public double getHumidity() {
        return 10;
    }

    @Override
    public double getPressure() {
        return 5;
    }
}
