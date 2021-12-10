package ru.netology.mythread;

public class MyThread extends Thread {

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2500);
                System.out.printf("Я %s, мой id:%d. Всем привет!\n"
                        , currentThread().getName()
                        , currentThread().getId());
            }
        } catch (InterruptedException e) {
            System.out.printf("%s завершен\n", currentThread().getName());
        }
    }
}
