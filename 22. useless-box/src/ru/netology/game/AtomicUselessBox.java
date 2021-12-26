package ru.netology.game;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicUselessBox implements UselessBox {
    private final AtomicBoolean isEnabled = new AtomicBoolean(false);
    private final Player mechanism = new MechanismPlayer(this);
    private final Player user = new HumanPlayer(this);

    public void turnOff() {
        isEnabled.set(false);
    }

    public void turnOn() {
        isEnabled.set(true);
    }

    public boolean isEnabled() {
        return isEnabled.get();
    }

    public void play() throws InterruptedException {
        mechanism.start();
        user.start();
        user.join();

        mechanism.interrupt();
    }
}
