package ru.geekbrains;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(1, 5);
        Point point2 = new Point(4, 10);
        Point point3 = new Point(0, 3);

        System.out.println(point);

        Triangle triangle = new Triangle(point2, point3, point);
        System.out.println(triangle);
    }

}
