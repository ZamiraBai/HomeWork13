package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        try {
            Semaphore semaphore = new Semaphore(4);
            CountDownLatch countDownLatch = new CountDownLatch(100);
            for (int i = 1; i <= 100; i++) {
                new Passenger(semaphore, countDownLatch, i).start();
            }

            countDownLatch.await();

            Thread.sleep(1000);
            System.out.println("Все пассажиры сели на места!");
            Thread.sleep(1000);
            System.out.println("Поехали!");
        } catch (InterruptedException ie) {
        }
    }
}

