package com.company;

public class CancelWithInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread helloThread = new Thread(() -> {
            while (true){
                System.out.println("Hello");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        helloThread.start();
        Thread.sleep(5000);
        helloThread.interrupt();

    }
}
