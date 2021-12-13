package ru.netology.binops;

public class BinOps {
    public final int numberSystems = 2;

    public String sum(String a, String b) {
        int arg1 = Integer.parseInt(a, numberSystems);
        int arg2 = Integer.parseInt(b, numberSystems);

        int result = arg1 + arg2;

        return Integer.toBinaryString(result);

    }

    public String mult(String a, String b) {
        int arg1 = Integer.parseInt(a, numberSystems);
        int arg2 = Integer.parseInt(b, numberSystems);

        int result = arg1 * arg2;

        return Integer.toBinaryString(result);

    }
}
