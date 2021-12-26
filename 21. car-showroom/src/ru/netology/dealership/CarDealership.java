package ru.netology.dealership;

import ru.netology.car.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDealership {
    private final List<Car> parking = new ArrayList<>();
    private Seller seller = new Seller(this);

    public Car sellCar() {
        return seller.sellСar();
    }

    public void pickUpCar(Car car) {
        seller.checkCar(car);
    }

    public boolean isParkingEmpty() {
        return parking.isEmpty();
    }

    public List<Car> getParking() {
        return parking;
    }
}
