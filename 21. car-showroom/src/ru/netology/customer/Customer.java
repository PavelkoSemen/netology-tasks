package ru.netology.customer;

import ru.netology.car.Car;
import ru.netology.dealership.CarDealership;

public class Customer implements Runnable {
    private CarDealership carDealership;
    private final int QUEUE_TIME = 2000;


    public Customer(CarDealership carDealership) {
        this.carDealership = carDealership;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(QUEUE_TIME);
            Car purchasedCar = carDealership.sellCar();
            System.out.printf("%s купил автомобиль: %s\n", Thread.currentThread().getName(), purchasedCar.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
