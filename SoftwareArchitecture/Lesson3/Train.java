package SoftwareArchitecture.Lesson3;

import java.util.ArrayList;
import java.util.List;

public class Train extends LandVehicle implements Transport{

    public Train(Coordinate currentCoordinate) {
        super(currentCoordinate);
    }

    public void drive(Path path) {
        System.out.printf("Train moves to (%f,%f)\n", path.endPoint.x, path.endPoint.y);
    }
    @Override
    public void moveTo(Coordinate toCoord) {
        drive(createPath(currentCoordinate, toCoord));
    }
    public Path createPath(Coordinate a, Coordinate b){
        return new Path(List.of(a, b));
    }
}
