package SoftwareArchitecture.Lesson3;

public class Cargo extends Deliverable{
    int insuranceCost;
    int places;

    public Cargo(Coordinate currentCoordinate) {
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
