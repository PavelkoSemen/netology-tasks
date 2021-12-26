package ru.netology.generator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Generator implements Function<String, List<String>> {
    private final static String delimiter = " ";

    @Override
    public List<String> apply(String text) {
        return Arrays.stream(text.split(delimiter))
                .sorted()
                .collect(Collectors.toList());
    }
}
