package ru.netology.frog;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() {
        position = 5;
    }



    public boolean jump(int steps) {
        int newPosition = position + steps;
        if (newPosition < MIN_POSITION || newPosition > MAX_POSITION) {
            return false;
        }
        position = newPosition;
        return true;
    }

    public void showPosition() {
        StringBuilder sb = new StringBuilder();
        for (int i = MIN_POSITION; i <= MAX_POSITION; i++) {
            if (i == position) {
                sb.append("*");
            }
            sb.append("-");
        }
        System.out.println(sb);
    }
}
