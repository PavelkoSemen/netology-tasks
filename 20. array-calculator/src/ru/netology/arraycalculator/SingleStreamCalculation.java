package ru.netology.arraycalculator;

public class SingleStreamCalculation {
    private final int [] values;

    public SingleStreamCalculation(int[] values) {
        this.values = values;
    }

    public int sumOfElements() {
        int total = 0;
        for (int value : values) {
            total += value;
        }
        return total;
    }

}
