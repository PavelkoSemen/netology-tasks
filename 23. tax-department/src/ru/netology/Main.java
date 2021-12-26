package ru.netology;

import ru.netology.department.TaxDepartment;
import ru.netology.shop.Shop;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int countShop = 3;
        final TaxDepartment taxDepartment = new TaxDepartment();
        final Shop shop = new Shop(taxDepartment);
        final List<Thread> shops = new ArrayList<>();

        // Создал
        for (int i = 0; i < countShop; i++) {
            shops.add(new Thread(shop::sendTaxes, "Shop " + (i + 1)));
        }

        // Запустил и подождал
        shops.forEach(Thread::start);
        for (Thread thread : shops) {
            thread.join();
        }

        System.out.println("В налоговую пришло: " + taxDepartment.getSumTax());
    }
}
