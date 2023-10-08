package SoftwareArchitecture.Lesson3;

import java.util.ArrayList;
import java.util.List;

public class Car extends LandVehicle {

    public Car(Coordinate currentCoordinate) {
        super(currentCoordinate);
    }

    public void drive(Path c) {
        System.out.printf("Car moves to (%f,%f)\n", c.endPoint.x, c.endPoint.y);
        currentCoordinate = c.endPoint;
    }
    @Override
    public void moveTo(Coordinate toCoord) {
        drive(createPath(currentCoordinate, toCoord));
    }
    public Path createPath(Coordinate a, Coordinate b){
        return new Path(List.of(a,b));
    }
}
