package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.models.TableModel;
import ru.geekbrains.lesson5.presenters.BookingPresenter;
import ru.geekbrains.lesson5.views.BookingView;

import java.util.Date;

public class Program {
    /**
     *TODO: ДЗ
     * метод changeReservationTable должен заработать
     * @param args
     */

    public static void main(String[] args) {

        BookingView bookingView = new BookingView();
        TableModel tableModel = new TableModel();
        BookingPresenter bookingPresenter = new BookingPresenter(bookingView, tableModel);

        bookingPresenter.showTables();

        bookingView.reservationTable(new Date(), 103, "Qwerty John");
        bookingPresenter.showTables();

        bookingView.changeReservationTable(9001, new Date(), 104, "Thomas Anderson");
        bookingPresenter.showTables();
    }
}
