package ru.geekbrains.lesson5.models;

import java.util.Collection;
import java.util.Date;

public interface Model {
    public Collection<Table> loadTables();

    public int reserveTable(Date date, int tableNum, String name);
}
