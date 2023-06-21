package ru.geekbrains.lesson7.adapter;

public interface MeteoSensor extends MeteoSensorBase {

    double getHumidity(); // Влажность
    double getPressure(); // Давление

}
