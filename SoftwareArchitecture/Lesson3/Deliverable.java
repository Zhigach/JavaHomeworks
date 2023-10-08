package SoftwareArchitecture.Lesson3;

public abstract class Deliverable {
    int mass;
    int volume;
    Coordinate currentCoordinate;
    Transport transport;

    abstract public void callTransport(Coordinate coordinate);
    abstract public void assignTransport(Transport transport);

    public Deliverable(Coordinate currentCoordinate) {
        this.currentCoordinate = currentCoordinate;
    }
}
