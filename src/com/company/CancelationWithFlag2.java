package com.company;

import java.util.concurrent.atomic.AtomicBoolean;

public class CancelationWithFlag2 {
    //using AtomicBoolean to interrupt Thread
    public static AtomicBoolean anotherIsRunning = new AtomicBoolean(true);

    //
    public static void main(String[] args){
        Thread hello = new Thread(() -> {
            while (anotherIsRunning.get()){
                System.out.println("Hello world, isRunning is " + anotherIsRunning.get());
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException ignore) {}
            }
        });
        hello.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        anotherIsRunning.set(false);

        System.out.println("isRunning is " + anotherIsRunning.get());
    }
}
