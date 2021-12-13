package ru.netology.test;

import java.util.Map;

public class SpeedTest {
    private final Map<Integer, Integer> testMap;
    private final int[] elements;

    public SpeedTest(Map<Integer, Integer> testMap, int[] elements) {
        this.testMap = testMap;
        this.elements = elements;
    }

    public Long addElements() {
        Long startTime = System.currentTimeMillis();
        for (int element : elements) {
            testMap.put(element, element);
        }
        Long finishTime = System.currentTimeMillis();

        return finishTime - startTime;
    }


    public Long getElements() {
        Long startTime = System.currentTimeMillis();
        for (int element : elements) {
            testMap.get(element);
        }
        Long finishTime = System.currentTimeMillis();

        return finishTime - startTime;
    }
}
