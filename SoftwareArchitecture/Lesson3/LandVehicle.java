package SoftwareArchitecture.Lesson3;

public abstract class LandVehicle implements Transport{
    Coordinate currentCoordinate;
    public abstract void drive(Path path);

    public LandVehicle(Coordinate currentCoordinate) {
        this.currentCoordinate = currentCoordinate;
    }
}
