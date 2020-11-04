package com.company;

import java.util.concurrent.*;

public class ExecutorThread {
    public static volatile boolean isShutdown = false;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> {
            print("Hello", 5, 1000);
            print("Goodbye", 10, 2000);
        });
        try {
            Thread.sleep(5_000);
            executor.shutdownNow();
            isShutdown = executor.isShutdown();
            executor.awaitTermination(3,TimeUnit.SECONDS);
        } catch (InterruptedException ignore){}
    }
    static void print(String message, int times, int interval) {
        try {
            for (int i=0; i<times; ++i) {
                System.out.println(message);
                if (isShutdown)
                    break;
                Thread.sleep(interval);
            }
        } catch (InterruptedException ignore){ }
    }
}
