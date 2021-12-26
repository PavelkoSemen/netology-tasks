package ru.netology.shop;

import ru.netology.department.TaxDepartment;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.LongStream;

public class Shop {
    private final TaxDepartment taxDepartment;

    public Shop(TaxDepartment taxDepartment) {
        this.taxDepartment = taxDepartment;
    }

    public void sendTaxes() {
        final long[] taxes = initArray();
        System.out.printf("%s отравил в налоговую %s\n"
                , Thread.currentThread().getName()
                , Arrays.toString(taxes));
        taxDepartment.collectTaxes(taxes);
    }


    private long[] initArray() {

        final int minThreshold = new Random().nextInt(1, 5);
        final int maxThreshold = new Random().nextInt(5, 10);

        return LongStream.range(minThreshold, maxThreshold).toArray();
    }
}
