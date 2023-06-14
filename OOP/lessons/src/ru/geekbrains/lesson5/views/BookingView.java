package ru.geekbrains.lesson5.views;

import ru.geekbrains.lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View{


    private ViewObserver observer;
    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    public void updateReservationTableResult(int reservationNum) {
        System.out.printf("Success! Your reservation number is #%d\n", reservationNum);
    }
    @Override
    public void updateTablesView(Collection<Table> tables) {
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    /**
     * Client pushed the reservation button
     * @param date booking date
     * @param tableNum table number
     * @param name client's name
     */
    public void reservationTable(Date date, int tableNum, String name) {
        observer.onReservationtable(date, tableNum, name);
    }

    /** TODO: Доработать метод в рамках ДЗ
     * Client asks us to change existing reservation
     * @param oldReservation
     * @param date
     * @param tableNum
     * @param name
     */
    public void changeReservationTable(int oldReservation, Date date, int tableNum, String name) {

    }
}
