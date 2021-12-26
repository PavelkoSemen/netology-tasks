package ru.netology;

import ru.netology.game.AtomicUselessBox;
import ru.netology.game.UselessBox;
import ru.netology.game.VolatileUselessBox;

public class Main {
    public static void main(String[] args) {

        //Через Volatile
        try {
            UselessBox uselessBox = new VolatileUselessBox();
            uselessBox.play();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Через Atomic
        try {
            UselessBox uselessBox = new AtomicUselessBox();
            uselessBox.play();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
