package ru.geekbrains.lesson1;

import java.util.List;

public class VendingMachine {

    private final List<Product> products;



    public VendingMachine(List<Product> products) {

        this.products = products;
    }

    public  BottleOfWater getBottleOfWater(double volume){

        for(Product product : products){
            if (product instanceof BottleOfWater){
               if ( ((BottleOfWater)product).getVolume()  == volume){
                   return (BottleOfWater)product;
               }
            }
        }
        return null;
    }
    public ChocolateBar getChocolate(int cocoaContains) {
        for (Product product:
             products) {
            if (product instanceof ChocolateBar) {
                if ( ((ChocolateBar) product).getCocoaContains() == cocoaContains) {
                    products.remove(product);
                    return (ChocolateBar) product;
                }
            }
        }
        return  null;
    }
}
