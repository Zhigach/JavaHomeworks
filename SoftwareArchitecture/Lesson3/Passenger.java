package SoftwareArchitecture.Lesson3;

public class Passenger extends Deliverable{
    String name;

    public Passenger(Coordinate currentCoordinate) {
        super(currentCoordinate);
    }

    public void callTransport(Coordinate destination){
        transport.moveTo(currentCoordinate);
        transport.moveTo(destination);
    }
    public void assignTransport(Transport transport) {
        this.transport = transport;
    }


}
