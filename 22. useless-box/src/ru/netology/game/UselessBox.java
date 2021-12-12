package ru.netology.game;

public interface UselessBox {
    void turnOff();


    void turnOn();

    boolean isEnabled();

    void play() throws InterruptedException;
}
