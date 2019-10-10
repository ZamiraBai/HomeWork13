package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passenger extends Thread {
    Semaphore sem;
    CountDownLatch latch;
    int id;

    public Passenger(Semaphore sem, CountDownLatch latch, int id) {
        this.sem = sem;
        this.latch = latch;
        this.id = id;
    }

    public synchronized void run() {
        try {
            sem.acquire();
            System.out.println("Пассажир " + id + " приобрел билет");
            sleep(1000);

            System.out.println("Пассажир " + id + " проходит на свое место");
            sem.release();

            sleep(1000);
            latch.countDown();
        } catch (InterruptedException e) {
        }
    }


}

