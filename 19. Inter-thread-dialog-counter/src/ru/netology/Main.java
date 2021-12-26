package ru.netology;

import ru.netology.messenger.Messenger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int countThread = Runtime.getRuntime().availableProcessors();
        final List<Callable<String>> callables = new ArrayList<>();
        final ExecutorService service = Executors.newFixedThreadPool(countThread);

        for (int i = 0; i < countThread; i++) {
            callables.add(new Messenger());
        }

        final List<Future<String>> futures = service.invokeAll(callables);

        System.out.println("Выводим все результаты");
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        System.out.println("Самый быстрый результат: " + service.invokeAny(callables));

        service.shutdown();
    }
}
