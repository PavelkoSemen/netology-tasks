package ru.netology.messenger;

import java.util.concurrent.Callable;

public class Messenger implements Callable<String> {

    @Override
    public String call() {
        int countMessage = (int) (Math.random() * 10);
        for (int i = 1; i <= countMessage; i++) {

            System.out.printf("----> [%s отправил %d сообщение.]\n", Thread.currentThread().getName(), i);

        }
        return String.format("%s отправил %d сообщений.", Thread.currentThread().getName(), countMessage);
    }
}
