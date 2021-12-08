package ru.netology.dealership;

import ru.netology.car.Car;

public class Seller {
    private int index = 0;
    private CarDealership dealership;

    public Seller(CarDealership dealership) {
        this.dealership = dealership;
    }
    public synchronized Car sellСar() {
        try {
            System.out.printf("%s пришел покупать автомобиль\n", Thread.currentThread().getName());
            while (dealership.isParkingEmpty()) {
                System.out.println("Машин нет");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return dealership.getParking().remove(index);
    }

    public synchronized void checkCar(Car car) {
        dealership.getParking().add(car);
        notify();
    }


}
