package ru.netology.callcenter;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CallCenter {


    private final ConcurrentLinkedQueue<String> processedCalls = new ConcurrentLinkedQueue<>();
    private final LinkedBlockingQueue<String> callsQueue = new LinkedBlockingQueue<>();


    public boolean call(String mobileNumber) {
        return callsQueue.offer(mobileNumber);
    }

    public String callProcessing() {
        // локальная переменная, так делать можно
        String processedCall = callsQueue.poll();
        if (processedCall != null) {
            processedCalls.offer(processedCall);
        }
        return processedCall;
    }

    public int getCountProcessedCalls() {
        return processedCalls.size();
    }

    public void printProcessedCalls() {
        System.out.println("Обработанные номера: " + processedCalls);
    }
}
