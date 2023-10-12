package SoftwareArchitecture.Lesson4;

import java.util.Date;
import java.util.Random;

public class Ticket {
    int rootNumber;
    int place;
    int price;
    Date date;
    boolean isValid(){
        return new Random().nextBoolean();
    }
}
