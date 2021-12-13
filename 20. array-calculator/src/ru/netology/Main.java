package ru.netology;

import ru.netology.arraycalculator.SingleStreamCalculation;
import ru.netology.arraycalculator.StreamCalculation;

import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args){
        final int lengthArray = 2_000_000_00;
        final int[] ints = initArray(lengthArray);

        SingleStreamCalculation singleCalculation = new SingleStreamCalculation(ints);
        final long startSingle = System.currentTimeMillis();
        final int total = singleCalculation.sumOfElements();
        final long finishSingle = System.currentTimeMillis();

        System.out.printf("Сумма полученная одним потоком: %d. Потраченое время -> {%d}\n"
                , total
                , finishSingle - startSingle);

        ForkJoinPool pool = (ForkJoinPool) Executors.newWorkStealingPool(4);
        StreamCalculation streamCalculation = new StreamCalculation(ints);

        final long startStream = System.currentTimeMillis();
        final int multiTotal = pool.invoke(streamCalculation);
        final long finishStream = System.currentTimeMillis();
        System.out.printf("Сумма полученная потоками: %d. Потраченое время -> {%d}\n"
                , multiTotal
                , finishStream - startStream);

        pool.shutdown();
    }


    private static int[] initArray(int count) {
        int[] ints = new int[count];

        for (int i = 0; i < count; i++) {
            ints[i] = 1;
        }

        return ints;
    }
}
