package ru.netology.randoms;

import java.util.Iterator;
import java.util.Random;


public class Randoms implements Iterable<Integer> {
    private final Random random = new Random();
    private final int max, min;

    public Randoms(int min, int max) {
        this.max = max + 1;
        this.min = min;
    }

    // Немного читер, не хочу создавать класс, хочу сделать так
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return random.nextInt(min, max);
            }
        };
    }
}
