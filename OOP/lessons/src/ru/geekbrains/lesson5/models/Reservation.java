package lessons.src.ru.geekbrains.lesson5.models;

import java.util.Date;

public class Reservation {
    private static int counter = 9000;
    private final int id;

    private String name;
    private Date date;

    {
        id = ++counter;
    }

    public Reservation(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}
