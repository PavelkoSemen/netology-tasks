package ru.netology.game;

public class VolatileUselessBox implements UselessBox {
    private volatile boolean isEnabled;
    private final Player mechanism = new MechanismPlayer(this);
    private final Player user = new HumanPlayer(this);

    public void turnOff() {
        isEnabled = false;
    }

    public void turnOn() {
        isEnabled = true;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void play() throws InterruptedException {
        mechanism.start();
        user.start();
        user.join();

        mechanism.interrupt();
    }
}
