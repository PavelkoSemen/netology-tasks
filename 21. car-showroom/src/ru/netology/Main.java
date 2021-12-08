package ru.netology;

import ru.netology.customer.Customer;
import ru.netology.dealership.CarDealership;
import ru.netology.manufacturer.Manufacturer;

public class Main {
    public static void main(String[] args) {
        final String nameManufacturer = "DeLorean";
        final int maxCar = 10;
        CarDealership carDealership = new CarDealership();
        Manufacturer manufacturer = new Manufacturer(nameManufacturer, carDealership);
        Customer customer = new Customer(carDealership);

        new Thread(manufacturer, "Завод").start();

        for (int i = 0; i < maxCar; i++) {
            new Thread(customer, "Покупатель " + (i + 1)).start();
        }

    }
}
