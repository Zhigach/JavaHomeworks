package ru.geekbrains.lesson5.presenters;

import ru.geekbrains.lesson5.models.Model;
import ru.geekbrains.lesson5.models.Table;
import ru.geekbrains.lesson5.views.View;
import ru.geekbrains.lesson5.views.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final View bookingView;

    private final Model tableModel;

    private void showReservationTableResult(int reservationNum) {
        bookingView.updateReservationTableResult(reservationNum);
    }

    public BookingPresenter(View bookingView, Model tableModel) {
        this.bookingView = bookingView;
        this.tableModel = tableModel;
        bookingView.setObserver(this);
    }

    private Collection<Table> loadTables() {
        return tableModel.loadTables();
    }

    public void showTables() {
        bookingView.updateTablesView(loadTables());
    }

    @Override
    public void onReservationtable(Date date, int tableNum, String name) {
        int reservationNum = tableModel.reserveTable(date, tableNum, name);
        showReservationTableResult(reservationNum);
    }
    public void onChangeReservationTable(int oldReservation, Date date, int tableNum, String name) {
        int reservationNum = tableModel.changeReservationTable(oldReservation, date, tableNum, name);
        showReservationTableResult(reservationNum);
    }
}
