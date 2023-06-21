package ru.geekbrains.lesson7.builder;

public class Program {

    public static void main(String[] args) {

        Order order = new OrderBuilder()
                .setClientName("Name")
                .setQnt(3)
                .setProduct("Product")
                .setPrice(300)
                .build();

    }

}
