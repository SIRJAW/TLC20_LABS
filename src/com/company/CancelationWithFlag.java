package com.company;

public class CancelationWithFlag {
    //using volatile to interrupt Thread
    public static volatile boolean isRunning = true;

    //
    public static void main(String[] args){
        Thread hello = new Thread(() -> {
            while (isRunning){
                System.out.println("Hello world, isRunning is " + isRunning);
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

        isRunning = false;

        System.out.println("isRunning is " + isRunning);
    }
}
