package ru.netology;

import ru.netology.binops.BinOps;

public class Main {
    public static void main(String[] args) {
        BinOps binOps = new BinOps();
        System.out.println(binOps.sum("11", "11"));
        System.out.println(binOps.mult("11", "11"));
    }
}
