package ru.netology.calculator;

import java.util.function.*;

public class Calculator {
    public static Supplier<Calculator> instance = Calculator::new;
    public BinaryOperator<Integer> plus = Integer::sum;
    public BinaryOperator<Integer> multiply = (x, y) -> x * y;

    /*
        В школьной математике делить на 0 нельзя, как один из вариантов, можно выводить максимальное значение Integer
        , аллюзия на бесконечность.
    */
    public BinaryOperator<Integer> devide = (x, y) -> y != 0 ? x / y : Integer.MAX_VALUE;
    public BinaryOperator<Integer> minus = (x, y) -> x - y;

    public UnaryOperator<Integer> pow = x -> x * x;
    public UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    public Predicate<Integer> isPositive = x -> x > 0;

    public Consumer<Integer> println = System.out::println;

}
