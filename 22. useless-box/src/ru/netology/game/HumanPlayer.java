package ru.netology.game;

public class HumanPlayer extends Player {
    private static final String name = "Человек";
    public int countReplace = 10;

    public HumanPlayer(UselessBox volatileUselessBox) {
        super(name, volatileUselessBox);
    }

    @Override
    public void run() {
        while (countReplace > 0) {
            if (!this.volatileUselessBox.isEnabled()) {
                System.out.printf("%s включил механизм\n", currentThread().getName());
                this.volatileUselessBox.turnOn();
                --countReplace;
            }
        }
        System.out.printf("%s осознал суть бытия, коробка его больше не привлекает\n", currentThread().getName());
    }
}
