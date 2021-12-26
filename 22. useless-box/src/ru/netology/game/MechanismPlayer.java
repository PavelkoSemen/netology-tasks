package ru.netology.game;

public class MechanismPlayer extends Player {
    private static final String name = "Механизм";

    public MechanismPlayer(UselessBox volatileUselessBox) {
        super(name, volatileUselessBox);
    }

    @Override
    public void run() {
        while (true) {
            if (isInterrupted()) {
                System.out.println("Коробку оставили скучать");
                break;
            }
            if (this.volatileUselessBox.isEnabled()) {
                System.out.printf("%s выключил механизм \n", currentThread().getName());
                volatileUselessBox.turnOff();
            }
        }
    }
}
