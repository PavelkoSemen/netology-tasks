package ru.netology;

import ru.netology.mythread.MyThread;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String group = "simpleGroup";
        ArrayList<Thread> threads = new ArrayList<>();
        int countThread = 4;
        ThreadGroup threadGroup = new ThreadGroup(group);

        //Создаю потоки
        System.out.println("Создаю потоки...");
        for (int i = 1; i <= countThread; i++) {
            threads.add(new MyThread(threadGroup, "поток " + i));
        }

        System.out.println("Запускаю потоки...");
        //Запускаю потоки
        for (Thread thread : threads) {
            thread.start();
        }

        //Пусть немного поработают
        Thread.sleep(10000);

        System.out.println("Завершаю все потоки.\n");
        threadGroup.interrupt();

    }
}
