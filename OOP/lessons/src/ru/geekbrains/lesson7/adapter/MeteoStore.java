package ru.geekbrains.lesson7.adapter;

public class MeteoStore {

    boolean save(MeteoSensor meteoSensor){
        System.out.printf("Сохранение данных по метеодатчику\nId = [%d];\nТемпература: %f;\nВлажность: %f;\nДавление: %f\n",
                meteoSensor.getId(), meteoSensor.getTemperature(),
                meteoSensor.getHumidity(), meteoSensor.getPressure());
        return true;
    }

    boolean save(MeteoSensorBase meteoSensor){
        System.out.printf("Сохранение данных по метеодатчику\nId = [%d];\nТемпература: %f;\n",
                meteoSensor.getId(), meteoSensor.getTemperature());
        return true;
    }

}
