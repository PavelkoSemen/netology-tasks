package ru.netology.arraycalculator;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class StreamCalculation extends RecursiveTask<Integer> {
    private final int THRESHOLD = 1_000_000;
    private int[] values;

    public StreamCalculation(int[] values) {
        this.values = values;
    }


    @Override
    protected Integer compute() {
        if (values.length < THRESHOLD) {
            int total = 0;
            for (int value : values) {
                total += value;
            }
            return total;
        } else {
            int middle = values.length / 2;
            StreamCalculation calculation1 = new StreamCalculation(Arrays.copyOfRange(values, 0, middle));
            calculation1.fork();
            StreamCalculation calculation2 = new StreamCalculation(Arrays.copyOfRange(values, middle, values.length));
            calculation2.fork();


            return calculation2.join() + calculation1.join();
        }

    }
}
