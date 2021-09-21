package ru.netology;

import ru.netology.listener.OnTaskDoneListener;
import ru.netology.listener.OnTaskErrorListener;
import ru.netology.worker.Worker;

public class Main {
    public static void main(String[] args) {
        OnTaskDoneListener doneListener = System.out::println;
        OnTaskErrorListener errorListener = System.out::println;

        Worker worker = new Worker(doneListener, errorListener);

        worker.start();

    }
}
