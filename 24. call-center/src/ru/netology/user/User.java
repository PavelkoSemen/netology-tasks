package ru.netology.user;

import ru.netology.callcenter.CallCenter;

import java.util.Random;

public class User implements Runnable {
    private int threshold;
    private final long CALL_FREQUENCY = 1000;
    private final CallCenter callCenter;
    // Просто для красоты
    private final Random random = new Random();

    public User(CallCenter callCenter, int threshold) {
        this.threshold = threshold;
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        try {
            while (threshold > 0) {
                String phoneNumber = "+8 998-326-48-" + random.nextInt(10, 99);
                if (callCenter.call(phoneNumber)) {
                    System.out.printf("%s удалось дозвониться по номеру: %s\n"
                            , Thread.currentThread().getName()
                            , phoneNumber);
                } else {
                    System.out.printf("%s не удалось дозвониться по номеру: %s\n"
                            , Thread.currentThread().getName()
                            , phoneNumber);
                }
                --threshold;
                Thread.sleep(CALL_FREQUENCY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
