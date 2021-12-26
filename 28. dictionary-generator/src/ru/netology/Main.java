package ru.netology;

import ru.netology.generator.Generator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final String delimiter = " ";
        Function<String, List<String>> generator = t -> Arrays.stream(t.split(delimiter))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(generator.apply("g s a w r g r h"));


    }

}
