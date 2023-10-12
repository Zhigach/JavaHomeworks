package SoftwareArchitecture.Lesson4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Customer {
    int id;
    CashProvider cash;
    List<Ticket> tickets;
    List<TicketProvider> ticketProviders;

    Customer(CashProvider  cashProvider) {
        this.cash = cashProvider;
    }

    public boolean buyTicket(Ticket ticket) {
        return new Random().nextBoolean();
    }
    public List<Ticket> searchTicket(Date date, int quantity) {
        List<Ticket> result = new ArrayList<>(quantity);
        for (Ticket ticket : result) {
            Random random = new Random();
            if (date.hashCode() % random.nextInt(10) == 0) {
                result.add(new Ticket());
            }
        }
        return result;
    }
}
