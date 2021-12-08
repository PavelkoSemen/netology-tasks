package ru.netology.dealership;

import ru.netology.car.Car;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Seller {
    private int index = 0;
    private CarDealership dealership;
    private final Lock locker = new ReentrantLock();
    private final Condition availabilityСar = locker.newCondition();

    public Seller(CarDealership dealership) {
        this.dealership = dealership;
    }
    public Car sellСar() {
        locker.lock();
        try {
            System.out.printf("%s пришел покупать автомобиль\n", Thread.currentThread().getName());
            while (dealership.isParkingEmpty()) {
                System.out.println("Машин нет");
                availabilityСar.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
        
        return dealership.getParking().remove(index);
    }


    public void checkCar(Car car) {
        locker.lock();
        dealership.getParking().add(car);
        availabilityСar.signal();
        locker.unlock();
    }


}
