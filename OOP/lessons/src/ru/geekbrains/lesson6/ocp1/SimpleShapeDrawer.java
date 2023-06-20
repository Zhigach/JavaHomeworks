package ru.geekbrains.lesson6.ocp1;

public class SimpleShapeDrawer {

    public void draw(Shape shape){
        switch (shape.getType()){
            case Circle -> drawCircle();
            case Square -> drawSquare();
            case Triangle -> drawTriangle();
            default -> throw new IllegalArgumentException();
        }
    }

    private void drawSquare(){
        //TODO: Отрисовка квадрата
    }

    private void drawCircle(){
        //TODO: Отрисовка окружности
    }

    private void drawTriangle(){
        //...
    }

}
