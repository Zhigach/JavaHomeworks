package ru.geekbrains.lesson7.adapter;

public class AdapterST500Info implements MeteoSensorBase {

    private SensorTemperature sensorTemperature;

    public AdapterST500Info(SensorTemperature sensorTemperature) {
        this.sensorTemperature = sensorTemperature;
    }

    @Override
    public int getId() {
        return sensorTemperature.identifier();
    }

    @Override
    public double getTemperature() {
        return sensorTemperature.temperature();
    }
}
