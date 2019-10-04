package com.wushiyii.jvm.demo.jmm;

public class VolatileTest {

    private static volatile int race = 0;

    private static void inc() {
        race++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[50];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    inc();
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println("Current : " + Thread.currentThread().getName() +"Race : " + race);
    }
}
