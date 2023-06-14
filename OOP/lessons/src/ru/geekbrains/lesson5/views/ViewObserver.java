package ru.geekbrains.lesson5.views;

import java.util.Date;

public interface ViewObserver {
    void onReservationtable(Date date, int tableNum, String name);

}
