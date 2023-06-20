package ru.geekbrains.lesson6.srp2;

import java.util.Scanner;

public class ConsoleOrderInitializer {
    private final Scanner scanner;

    ConsoleOrderInitializer() {
        scanner = new Scanner(System.in);
    }

    public void inputFromConsole(Order order){
        order.setClientName(prompt("Client name: "));
        order.setProduct(prompt("Product: "));
        order.setQnt(Integer.parseInt(prompt("Quantity: ")));
        order.setPrice(Integer.parseInt(prompt("Price: ")));
    }

    private String prompt(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

}
