package ru.netology.workwithlist;

import java.util.Arrays;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        intList.stream()
                .filter(v -> v > 0)
                .filter(v -> v % 2 ==0)
                .sorted()
                .forEach(v -> System.out.print(v + " "));
    }
}
