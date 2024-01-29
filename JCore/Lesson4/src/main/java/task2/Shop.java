package task2;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Shop {
    private static final List<Customer> customerList = new ArrayList<>();
    private static final List<Product> productList = new ArrayList<>();
    private static final List<Order> orderList = new ArrayList<>();

    public static void celebrate(LocalDate localDate) {
        MonthDay currentMonthDay = MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
        for (Holidays holiday : Holidays.values()) {
            if (Holidays.getHoliday(holiday).monthDay.equals(currentMonthDay)) {
                //Notify customers
                Set<Sex> sexSet = Holidays.getHoliday(holiday).sex;
                for (Customer customer : customerList) {
                    if (sexSet.contains(customer.sex)) {
                        System.out.printf("Congratulations with %s, Dear %s\n", holiday, customer);
                    }
                }
            }
        }

    }

    public static Order buyGoods(Customer customer, Product product, int quantity) {
        if (!customerList.contains(customer)) {
            throw new CustomerException("Customer is not in the customers list");
        }
        if (!productList.contains(product)) {
            throw new ProductException("The product is missing in the shop");
        }
        if (quantity <= 0) {
            throw new AmountException("Product quantity must be greater than zero", quantity);
        }
        return new Order(customer, product, quantity);
    }

    public static void main(String[] args) {

        customerList.add(new Customer("Ivan Ivan", LocalDate.of(1990, 5, 6), "+79536451549", Sex.MALE));
        customerList.add(new Customer("Gadya Hrenova", LocalDate.of(1980, 10, 1), "+79536643549", Sex.FEMALE));


        productList.add(new Product("Water 0.5L", 50.0));
        productList.add(new Product("Tea 100 bags", 250.0));
        productList.add(new Product("Bread 500g", 45.0));
        productList.add(new Product("Water 5L", 105.0));
        productList.add(new Product("Milk 900 mL", 101.0));

        List<Customer> testCustomerList = new ArrayList<>(customerList);
        testCustomerList.add(new Customer("Test Penetra", LocalDate.of(1990,5,6),"+79536451549", Sex.MALE));
        List<Product> testProductList = new ArrayList<>(productList);
        testProductList.add(new Product("Air 1L", 500000.0));

        Random random = new Random();
        for (Product product : testProductList) {
            for (Customer customer : testCustomerList) {
                try {
                    orderList.add(buyGoods(customer, product, random.nextInt(-10, 100)));
                }
                catch (CustomerException exception) {
                    System.out.printf("Incorrect customer %s selected. Contact the support, please.\n", customer);
                } catch (ProductException exception) {
                    System.out.printf("The product %s you're searching is missing in the store.\n", product);
                } catch (AmountException exception) {
                    System.out.printf("Amount must be greater than zero. %d provided.%n\n", exception.incorrectValue);
                }
            }
        }
        System.out.printf("Full orders list contains %s records\n%n", orderList.size());

        celebrate(LocalDate.of(2023, 3, 8));
    }
}
