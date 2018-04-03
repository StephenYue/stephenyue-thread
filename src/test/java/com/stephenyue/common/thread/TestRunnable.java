package com.stephenyue.common.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestRunnable implements Runnable{
    private static AtomicInteger atomicInteger = new AtomicInteger();
    public void run() {
        try {
            System.out.println(atomicInteger.getAndIncrement());
            Thread.sleep(1 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
