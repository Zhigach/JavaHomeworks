package SoftwareArchitecture.Lesson3;

public interface Transport {
    void moveTo(Coordinate c);
    Path createPath(Coordinate a, Coordinate b);

}
