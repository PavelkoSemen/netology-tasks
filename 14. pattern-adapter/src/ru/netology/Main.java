package ru.netology;

import ru.netology.calculator.Ints;
import ru.netology.calculator.IntsCalculator;

public class Main {
    public static void main(String[] args) {
        Ints calc = new IntsCalculator();
        System.out.println(calc.sum(1, 4));
        System.out.println(calc.mult(2, 4));
        System.out.println(calc.pow(2, 4));
    }
}
