package ru.geekbrains.lesson6.srp2;

public class Program {


    public static void main(String[] args) {

        Order order = new Order();

        ConsoleOrderInitializer orderInitializer = new ConsoleOrderInitializer();
        orderInitializer.inputFromConsole(order);

        OrderFileFormatter orderFileFormatter = new OrderFileFormatter();
        orderFileFormatter.saveToJson(order);

    }

}
