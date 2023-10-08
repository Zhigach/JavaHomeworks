package SoftwareArchitecture.Lesson3;

import java.util.List;

public class Path {
    Coordinate startPoint;
    Coordinate endPoint;
    List<Coordinate> pathPoints;
    public Path(List<Coordinate> pathPoints) {
        this.pathPoints = pathPoints;
        startPoint = pathPoints.get(0);
        endPoint = pathPoints.get(pathPoints.size()-1);
    }
}
