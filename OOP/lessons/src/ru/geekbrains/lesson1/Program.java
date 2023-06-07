package ru.geekbrains.lesson1;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        int a = 12;



        Product product1 = new Product();
        System.out.println(product1.displayInfo());

        Product product2 = new Product("ООО Чистый Источник", "Бутылка с водой #2", -90.15);
                product2.setPrice(-30);
        System.out.println(product2.displayInfo());

        BottleOfWater bottleOfWater1 =
                new BottleOfWater("ООО Чистый Источник", "Бутылка с водой #3", -90.15, 1.5);
        System.out.println(bottleOfWater1.displayInfo());

        Product bottleOfMilk
                = new BottleOfMilk("ООО Чистый Источник", "Бутылка с молоком #1", -90.15, 1.5, 10);
        System.out.println(bottleOfMilk.displayInfo());

        Product chocolateBar1
                = new ChocolateBar("ПАО Бабаевский", "Элитный  #1", 125.00, 75);
        System.out.println(chocolateBar1.displayInfo());

        Product chocolateBar2
                = new ChocolateBar("ПАО Такф", "Классический  #1", 112.00, 45);
        System.out.println(chocolateBar2.displayInfo());

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(bottleOfWater1);
        products.add(bottleOfMilk);
        products.add(chocolateBar1);
        products.add(chocolateBar2);



        VendingMachine vendingMachine = new VendingMachine(products);
        BottleOfWater bottleOfWaterResult = vendingMachine.getBottleOfWater(1.5);
        if (bottleOfWaterResult != null){
            System.out.println("Вы купили:\n" + bottleOfWaterResult.displayInfo());
        }
        else {
            System.out.println("Такой бутылки с водой нет в автомате.");
        }

        ChocolateBar requestedChocolateBar = vendingMachine.getChocolate(75);
        if (requestedChocolateBar != null) {
            System.out.println("Вы купили:\n" + requestedChocolateBar.displayInfo());
        } else {
            System.out.println("Сожалеем. Такого шоколада нет.");
        }


    }

}
