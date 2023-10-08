package SoftwareArchitecture.Lesson3;

import java.util.List;

public class Airplane extends Flying {

    public Airplane(Coordinate currentCoordinate) {
        super(currentCoordinate);
    }

    public void flyByPath(Path path) {
        System.out.printf("Plane flies to (%f,%f)\n", path.endPoint.x, path.endPoint.y);
        currentCoordinate = path.endPoint;
    }

    @Override
    public void moveTo(Coordinate coordinate){
        flyByPath(createPath(currentCoordinate, coordinate));
    }

    @Override
    public Path createPath(Coordinate a, Coordinate b){
        return new Path(List.of(a, b));
    }
}
