package SoftwareArchitecture.Lesson3;

public abstract class Flying implements Transport{
    Coordinate currentCoordinate;
    public abstract void flyByPath(Path path);

    public Flying(Coordinate currentCoordinate) {
        this.currentCoordinate = currentCoordinate;
    }
}
