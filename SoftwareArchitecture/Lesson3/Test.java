package SoftwareArchitecture.Lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        List<Deliverable> deliverables = new ArrayList<>();
        Deliverable cargo1 = new Cargo(new Coordinate(10, 10));
        cargo1.assignTransport(new Train(new Coordinate( 0,0)));
        Deliverable passenger1 = new Passenger(new Coordinate(5,5));
        passenger1.assignTransport(new Airplane(new Coordinate(-10,-10)));
        deliverables.add(cargo1);
        deliverables.add(passenger1);

        Random random = new Random();
        for (Deliverable deliverable : deliverables) {
            deliverable.callTransport(new Coordinate(random.nextDouble(), random.nextDouble()));
        }
    }

}
