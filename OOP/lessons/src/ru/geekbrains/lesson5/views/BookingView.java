package lessons.src.ru.geekbrains.lesson5.views;

import lessons.src.ru.geekbrains.lesson5.models.Reservation;
import lessons.src.ru.geekbrains.lesson5.models.Table;

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
        System.out.println("TABLES RESERVATION INFO:");
        for (Table table: tables) {
            System.out.println(table);
            for (Reservation reservation: table.getReservations()) {
                System.out.printf("\tReservation #%d: Client - %s\n", reservation.getId(), reservation.getName());
            }
        }
        System.out.println("--- END ---\n\n");
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

    /**
     * Client asks us to change existing reservation
     * @param oldReservation old reservation number
     * @param date new date
     * @param tableNum number of new table to reserve
     * @param name client's name
     */
    public void changeReservationTable(int oldReservation, Date date, int tableNum, String name) {
        observer.onChangeReservationTable(oldReservation, date, tableNum, name);
    }
}
