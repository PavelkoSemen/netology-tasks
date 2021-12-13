package ru.netology;

import ru.netology.test.SpeedTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main {
    private final static ExecutorService service = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws Exception {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        Map<Integer, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());

        System.out.println("Скорость записи в ConcurrentHashMap: " + speedAdd(concurrentHashMap));
        System.out.println("Скорость записи в SynchronizedMap: " + speedAdd(synchronizedMap));

        System.out.println("Скорость чтения из ConcurrentHashMap: " + speedGet(concurrentHashMap));
        System.out.println("Скорость чтения из SynchronizedMap: " + speedGet(synchronizedMap));

        service.shutdown();
    }


    private static long speedAdd(Map<Integer, Integer> map) throws InterruptedException, ExecutionException {
        List<Future<Long>> futures = service.invokeAll(List.of(
                new SpeedTest(map, IntStream.range(0, 10000).toArray())::addElements
                , new SpeedTest(map, IntStream.range(10000, 20000).toArray())::addElements
                , new SpeedTest(map, IntStream.range(20000, 30000).toArray())::addElements
                , new SpeedTest(map, IntStream.range(30000, 40000).toArray())::addElements
        ));

        long totalTime = 0;
        for (Future<Long> future : futures) {
            totalTime += future.get();
        }

        return totalTime;
    }

    private static long speedGet(Map<Integer, Integer> map) throws InterruptedException, ExecutionException {
        List<Future<Long>> futures = service.invokeAll(List.of(
                new SpeedTest(map, IntStream.range(0, 10000).toArray())::getElements
                , new SpeedTest(map, IntStream.range(10000, 20000).toArray())::getElements
                , new SpeedTest(map, IntStream.range(20000, 30000).toArray())::getElements
                , new SpeedTest(map, IntStream.range(30000, 40000).toArray())::getElements
        ));

        long totalTime = 0;
        for (Future<Long> future : futures) {
            totalTime += future.get();
        }

        return totalTime;
    }


}
