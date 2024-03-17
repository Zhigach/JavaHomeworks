package ru.geekbrains;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;


public class Circle {
    Radius radius;
    Point center;

    public Circle(Radius radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
