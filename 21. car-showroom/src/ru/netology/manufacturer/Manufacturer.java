package ru.netology.manufacturer;

import ru.netology.car.Car;
import ru.netology.dealership.CarDealership;

import java.util.Random;

public class Manufacturer implements Runnable {
    private final String name;
    private int maxCurs = 10;
    private final int TIME_TO_CREATE_CAR = 2000;
    private CarDealership carDealership;

    public Manufacturer(String name, CarDealership carDealership) {
        this.name = name;
        this.carDealership = carDealership;
    }

    @Override
    public void run() {
        while (maxCurs > 0) {
            Car car = createCar();
            System.out.println("Создана машина: " + car);
            carDealership.pickUpCar(car);
            --maxCurs;
        }
    }


    private Car createCar() {
        try {
            Thread.sleep(TIME_TO_CREATE_CAR);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Car(name, new Random().nextInt(40, 100));
    }
}
