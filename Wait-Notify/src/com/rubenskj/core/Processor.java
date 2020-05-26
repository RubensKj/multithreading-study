package com.rubenskj.core;

import java.util.Scanner;

public class Processor {

    private Object lock = new Object();

    public void produce() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Producer thread running...");
            lock.wait();
            System.out.println("Resumed.");
        }
    }

    public void consume() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (lock) {
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            lock.notify();
            Thread.sleep(5000);
        }
    }
}
