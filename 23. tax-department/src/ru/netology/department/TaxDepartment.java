package ru.netology.department;

import java.util.Arrays;
import java.util.concurrent.atomic.LongAdder;

public class TaxDepartment {
    private final LongAdder totalTax = new LongAdder();

    public void collectTaxes(long... taxes) {
        Arrays.stream(taxes)
                .forEach(totalTax::add);
    }

    public Long getSumTax() {
        return totalTax.sum();
    }
}
