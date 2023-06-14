package lessons.src.ru.geekbrains.lesson5.views;

import java.util.Date;

public interface ViewObserver {
    void onReservationtable(Date date, int tableNum, String name);

    void onChangeReservationTable(int oldReservation, Date date, int tableNum, String name);
}
