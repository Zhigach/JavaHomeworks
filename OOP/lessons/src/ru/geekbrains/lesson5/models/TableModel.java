package ru.geekbrains.lesson5.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model{

    private Collection<Table> tables;

    /**
     * Get list of all tables
     * @return
     */
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    /**
     * Table reservation
     * @param date reservation date
     * @param tableNum tab;e number
     * @param name client's name
     * @return reservation number
     */
    public int reserveTable(Date date, int tableNum, String name) {
        for (Table table: tables) {
            if (table.getNo() == tableNum) {
                Reservation reservation = new Reservation(name, date);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return  -1;  //throw new RuntimeException("Incorrect table number");
    }


    /** TODO:  Разработать метод самостоятельно в рамках домашнего задания
     * Change the reservation parameters (create new reservation in exchange)
     * @return
     */
    public boolean changeReservationTable() {
        //TODO: использовать существующий метод создания резерва
        return true;
    }
}
