package SoftwareArchitecture.Lesson4;

import java.util.List;

public class CashProvider {
    private long cardNumber;
    private boolean isAuthorization;
    List<TicketProvider> ticketProviders;
    public boolean authorization (Customer customer) {
        return customer.id % 2 == 0;
    }
    public void buy(int price) {
        
    }
}
