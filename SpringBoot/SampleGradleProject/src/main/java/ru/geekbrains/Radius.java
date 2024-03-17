package ru.geekbrains;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public record Radius(int length) {
    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
